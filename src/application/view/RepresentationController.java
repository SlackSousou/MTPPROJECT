package application.view;




import java.sql.SQLException;

import application.Main;
import application.model.AdherantDAO;
import application.model.Representation;
import application.model.RepresentationDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class RepresentationController {
	@FXML
	private TableView<Representation> personTable;
	@FXML
	private TableColumn<Representation, String> numRepresentationColumn;
	@FXML
	private TableColumn<Representation, String> numSpectacleColumn;
	@FXML
	private TableColumn<Representation, Integer> numSalleColumn;

	@FXML
	private Label numRepresentationLabel;
	@FXML
	private Label numSpectacleLabel;
	@FXML
	private Label numSalleLabel;
	@FXML
	private Label dateRepresentationLabel;
	@FXML
	private Label tarifLabel;

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
	public void searchRepresentations() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			//Get all Employees information
			ObservableList<Representation> repData = RepresentationDAO.searchRepresentations();
			//Populate Employees on TableView
			populateRepresentations(repData);
		} catch (SQLException e){
			System.out.println("Error occurred while getting clients information from DB.\n" + e);
			throw e;
		}
	}
	private void populateRepresentations (ObservableList<Representation> repData) throws ClassNotFoundException {
		//Set items to the employeeTable
		personTable.setItems(repData);
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
		numRepresentationColumn.setCellValueFactory(cellData -> cellData.getValue().numRepresentationProperty());
		numSpectacleColumn.setCellValueFactory(cellData -> cellData.getValue().numSpectacleProperty());
		numSalleColumn.setCellValueFactory(cellData -> cellData.getValue().numSalleProperty().asObject());
		searchRepresentations();
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
	private void showPersonDetails(Representation representation) {
		if (representation != null) {
			// Fill the labels with info from the person object.
			numRepresentationLabel.setText(Integer.toString(representation.getnumRepresentation()));
			numSpectacleLabel.setText(Integer.toString(representation.getnumSpectacle()));
			numSalleLabel.setText(Integer.toString(representation.getnumSalle()));
			dateRepresentationLabel.setText(Integer.toString(representation.getdateRepresentation()));
			tarifLabel.setText(Integer.toString(representation.gettarif()));



		} else {
			// Person is null, remove all the text.
			numRepresentationLabel.setText("");
			numSpectacleLabel.setText("");
			numSalleLabel.setText("");
			dateRepresentationLabel.setText("");
			tarifLabel.setText("");
		}
	}

	@FXML
	private void handleAdherant() {
		mainApp.showAdherant();
	}  

	// *************************BOUTON SUPPRIMER*************************************
	@FXML
	private void handleDeleteRepresentation() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			AdherantDAO.deleteAdherantWithId(numRepresentationLabel.getText());
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
	private void handleNewRepresentation() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		mainApp.showNewRepresentation();
	}

	// *************************BOUTON MODIFIER*************************************
	@FXML
	private void handleEditRepresentation() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		Representation selectedRepresentation  = personTable.getSelectionModel().getSelectedItem();
		if (selectedRepresentation  != null) {
			boolean okClicked = mainApp.showRepresentationEdit(selectedRepresentation );
			if (okClicked) {
				showPersonDetails(selectedRepresentation);
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
