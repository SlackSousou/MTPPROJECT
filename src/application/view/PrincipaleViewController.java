package application.view;


import java.sql.SQLException;

import application.Main;
import application.model.Adherent;
import application.model.AdherentDAO;
import application.model.Representation;
import application.model.RepresentationDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;




public class PrincipaleViewController {



	@FXML
	private ComboBox<Adherent> adherentField;
	@FXML
	private ComboBox<Representation> representationField;
	@FXML
	private TextField NbrPersonneField ; 
	@FXML
	private TextField prixTotalField ; 




	private Main main;
	private Adherent adherent;
	private Representation representation;



	public PrincipaleViewController() {
	}


	public void setMain(Main main) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		// TODO Auto-generated method stub
		representationField.getItems().addAll(searchRepresentation());
		adherentField.getItems().addAll(searchAdherent());

	}


	public void setReservation(Adherent adherent , Representation representation) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		this.adherent = adherent;
		this.representation = representation;
		ObservableList<Adherent> optionsAd =  AdherentDAO.ChercherAdherentsListe();
		ObservableList<Representation> optionsRep =  RepresentationDAO.ChercherRepresentationsListe();
	}

	public ObservableList<Adherent> searchAdherent() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			//Get all Employees information
			ObservableList<Adherent> adData = AdherentDAO.ChercherAdherentsListe();
			return adData;
		} catch (SQLException e){
			System.out.println("Error occurred while getting Adherent information from DB.\n" + e);
			throw e;
		}
	}
	public ObservableList<Representation> searchRepresentation() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			//Get all Employees information
			ObservableList<Representation> repData = RepresentationDAO.ChercherRepresentationsListe();
			return repData;
			//  ObservableList<Representation> repData = RepresentationDAO.searchRepresentations();
		} catch (SQLException e){
			System.out.println("Error occurred while getting representations information from DB.\n" + e);
			throw e;
		}
	}


	@FXML
	private void initialize(){
		NbrPersonneField.setText("1");
		}
	// Selection de deux bouton "Valider" et "Quitter"
	@FXML
	private void handleValider() {
	}          

	@FXML
	private void handleQuitter() {
	}    
}