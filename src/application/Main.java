package application;

import application.model.Adherant;
import application.model.Representation;
import application.view.PrincipaleViewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {


    private Stage primaryStage;
    private AnchorPane fenetrePrincipal;
    
    /**
	 * The data as an observable list of Persons.
	 */
    private ObservableList<Representation> representationData = FXCollections.observableArrayList();
	private ObservableList<Adherant> adherantData = FXCollections.observableArrayList();
	
	
	/**
	 * Returns the data as an observable list of representant .
	 * 
	 * @return
	 */
    public ObservableList<Representation> getRepresentationData() {
		return representationData;
	}
    public ObservableList<Adherant> getAdherantData() {
  		return adherantData;
  	}

    @Override

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("PrincipaleView");

        try {

            // charge le menu client a partir du fichier fxml
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Main.class.getResource("view/PrincipaleView.fxml"));
                        fenetrePrincipal = (AnchorPane) loader.load();  

                       
                        // affichage de la scene contenant la fenetre principale.
                        Scene scene = new Scene(fenetrePrincipal);
                        primaryStage.setScene(scene);

                        // Donne l'accès au contrôleur main app.
                        PrincipaleViewController controller = loader.getController();
                        controller.setMain(this);

                        // affichage du primaryStage
                        primaryStage.show();  


        } catch(Exception e) {

            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);

    }

}