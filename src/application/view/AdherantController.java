package application.view;

import java.sql.SQLException;

import application.Main;
import application.model.Adherant;
import application.model.AdherantDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class AdherantController {
	@FXML
	private TableView<Adherant> personTable;
	@FXML
	private TableColumn<Adherant, String> nomColumn;
	@FXML
	private TableColumn<Adherant, String> prenomColumn;
	@FXML
	private TableColumn<Adherant, Integer> identifiantColumn;
	
	@FXML
	private Label numAdherantLabel;
	@FXML
	private Label nomLabel;
	@FXML
	private Label prenomLabel;
	@FXML
	private Label adresseLabel;
	
	private Main mainApp;
	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
		
		// Add observable list data to the table
		
	} 
	public void searchAdherants() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			//Get all Employees information
			ObservableList<Adherant> adData = AdherantDAO.searchAdherants();
			//Populate Employees on TableView
			populateAdherants(adData);
		} catch (SQLException e){
			System.out.println("Error occurred while getting clients information from DB.\n" + e);
			throw e;
		}
	}
	private void populateAdherants (ObservableList<Adherant> adData) throws ClassNotFoundException {
		//Set items to the employeeTable
		personTable.setItems(adData);
	}
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	@FXML
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		// Initialize the person table with the two columns.
		nomColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		prenomColumn.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
		identifiantColumn.setCellValueFactory(cellData -> cellData.getValue().identifiantProperty().asObject());
		searchAdherants();
		// Clear person details.
		showPersonDetails(null);

		// Listen for selection changes and show the person details when changed.
		personTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showPersonDetails(newValue));
	}

	/**
	 * Fills all text fields to show details about the person.
	 * If the specified person is null, all text fields are cleared.
	 *
	 * @param person the person or null
	 */
	private void showPersonDetails(Adherant adherant) {
		if (adherant != null) {
			// Fill the labels with info from the person object.
			numAdherantLabel.setText(Integer.toString(adherant.getIdentifiant()));
			nomLabel.setText(adherant.getNom());
			prenomLabel.setText(adherant.getPrenom());
			adresseLabel.setText(adherant.getAdresse());
		       
		} else {
			// Person is null, remove all the text.
			numAdherantLabel.setText("");
			nomLabel.setText("");
			prenomLabel.setText("");
			adresseLabel.setText("");
			
		}
}

	@FXML
	private void handleRepresentation() {
		mainApp.showRepresentation();
	}  
	
	// *************************BOUTON SUPPRIMER*************************************
	@FXML
    private void handleDeleteAdherant() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	AdherantDAO.deleteAdherantWithId(numAdherantLabel.getText());
            personTable.getItems().remove(selectedIndex);
           
        } else {
            // Rien de selectionné
            Alert alert = new Alert(AlertType.WARNING);
               alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Aucune Selection");
                alert.setHeaderText("Aucune Personne Selectionné");
                alert.setContentText("Selectionner une personne sur la table");
                alert.showAndWait();
            }
    }
	
    // *************************BOUTON NOUVEAU*************************************
    @FXML
    private void handleNewAdherant() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        mainApp.showNewAdherant();
    }

    // *************************BOUTON MODIFIER*************************************
    @FXML
    private void handleEditAdherant() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
      Adherant selectedAdherant  = personTable.getSelectionModel().getSelectedItem();
       if (selectedAdherant  != null) {
            boolean okClicked = mainApp.showAdherantEdit(selectedAdherant );
            if (okClicked) {
              showPersonDetails(selectedAdherant);
            }

        }
    else {
            // Si rien est selectionné
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Aucune Selection");
            alert.setHeaderText("Aucune Personne Selectionné");
            alert.setContentText("Selectionner une personne sur la table");

            alert.showAndWait();
        }
    }
    
    @FXML
	private void handleLogo() {
		mainApp.showPrincipaleOverView();
	}
}
