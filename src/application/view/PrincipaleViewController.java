package application.view;


import java.sql.SQLException;

import application.Main;
import application.model.Adherant;
import application.model.AdherantDAO;
import application.model.Representation;
import application.model.RepresentationDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;




public class PrincipaleViewController {
	
	
	
    @FXML
    private ComboBox<Adherant> adherentField;
    @FXML
    private ComboBox<Representation> representationField;
    @FXML
    TextField NbrPersonneField ; 
    @FXML
    TextField prixTotalField ; 


    
    
    private Main main;
    private Adherant adherant;
    private Representation representation;
 


    public PrincipaleViewController() {
    }
    
    
    public void setMain(Main main) {
        // TODO Auto-generated method stub

    }
    
    
    public void setReservation(Adherant adhearant , Representation representation) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        this.adherant = adherant;
        this.representation = representation;
        ObservableList<Adherant> optionsAd =  AdherantDAO.searchAdherants();
        ObservableList<Representation> optionsRep =  RepresentationDAO.searchRepresentations();
    }

        public void searchAdherant() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            try {
                //Get all Employees information
                ObservableList<Adherant> adData = AdherantDAO.searchAdherants();

            } catch (SQLException e){
                System.out.println("Error occurred while getting clients information from DB.\n" + e);
                throw e;
            }
        }
        public void searchRepresentation() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            try {
                //Get all Employees information
              //  ObservableList<Representation> repData = RepresentationDAO.searchRepresentations();
            } catch (SQLException e){
                System.out.println("Error occurred while getting clients information from DB.\n" + e);
                throw e;
            }
        }

    
    @FXML
    private void initialize(){

    }
    // Selection de deux bouton "Valider" et "Quitter"
    @FXML
    private void handleValider() {
    }          

    @FXML
    private void handleQuitter() {
    }    
}