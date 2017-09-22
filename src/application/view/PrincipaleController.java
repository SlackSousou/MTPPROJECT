package application.view;

import java.io.IOException;

import application.Main;
import application.View.RepresentantController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;


public class PrincipaleController {
	private Main mainApp;
	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		// personTable.setItems(mainApp.getPersonData());
	} 
	/**
	 * Called when the user clicks the prospect Item. Opens the propspect view
	 * 
	 */
	@FXML
	private void handleAdherant() {
		mainApp.showAdherant();
	}          
	/**
	 *  Called when the user clicks the Representant Item. Opens the representant view
	 *
	 */
	@FXML
	private void handleRepresentation() {
		mainApp.showRepresentation();
	}  
	/**
	 * Shows the represent inside the root layout.
	 */
	public void showRepresentant() {
		try {
			// Load representant view.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application/View/Representant.fxml"));
			AnchorPane representant = (AnchorPane) loader.load();

			// Set representant view into the center of root layout.
			rootLayout.setCenter(representant);

			// Give the controller access to the main app.
			RepresentantController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}   
}