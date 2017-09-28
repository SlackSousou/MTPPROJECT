package application.view;


import java.sql.SQLException;

import application.Main;
import application.model.Adherent;
import application.model.AdherentDAO;
import application.model.Representation;
import application.model.RepresentationDAO;
import application.util.DateUtil;
import javafx.application.Platform;
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
	public  TextField nbrPersonneField ; 
	@FXML
	public  TextField prixTotalField ; 




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

	// METHODE utilisé pour les Reservation
	public void setReservation(Adherent adherent , Representation representation) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		this.adherent = adherent;
		this.representation = representation;
		ObservableList<Adherent> optionsAd =  AdherentDAO.ChercherAdherentsListe();
		ObservableList<Representation> optionsRep =  RepresentationDAO.ChercherRepresentationsListe();
		CalculTarif();
	}


	//ComboBox Adherant
	public ObservableList<Adherent> searchAdherent() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			//Donne toute les information de "Adherant"
			ObservableList<Adherent> adData = AdherentDAO.ChercherAdherentsListe();
			return adData;
		} catch (SQLException e){
			System.out.println("Error occurred while getting Adherent information from DB.\n" + e);
			throw e;
		}
	}

	//ComboBox Representation
	public ObservableList<Representation> searchRepresentation() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			//Donne toute les information de "Representation"
			ObservableList<Representation> repData = RepresentationDAO.ChercherRepresentationsListe();
			return repData;
		} catch (SQLException e){
			System.out.println("Error occurred while getting representations information from DB.\n" + e);
			throw e;
		}
	}

	// METHODE me permettant de calculer le tarif
	public void CalculTarif() throws NumberFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		// SelectModel et SelectItem sont les representation ou j'ai cliqué
		Representation represent = representationField.getSelectionModel().getSelectedItem();
		// Chercher dans representation le tarif de la representation.
		double tarif = representation.tarif();		// 
		prixTotalField.setText(Double.toString((Integer.parseInt(nbrPersonneField.getText()))*tarif));
	}


	@FXML
	private void initialize(){
		nbrPersonneField.setText("1");
		//prixTotalField.setPromptText("0");
	}


	// Bouton Valider permet de valider la reservation
	@FXML
	private void handleValider() {
	}          


	// Bouton "Quitter" permet de fermer l'application
	@FXML
	private void handleQuitter() {
		Platform.exit();
	}    
}