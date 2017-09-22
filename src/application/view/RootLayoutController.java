package application.view;

import java.io.File;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;


public class RootLayoutController {

	private Main mainApp;

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}



	/**
	 * Opens a FileChooser to let the user select an address book to load.
	 */
	@FXML
	private void handleOpen() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

		if (file != null) {
	         //   mainApp.loadPersonDataFromFile(file);
	        }
	}
	/**
	 * Saves the file to the person file that is currently open. If there is no
	 * open file, the "save as" dialog is shown.
	 */
	@FXML
	private void handleSave() {
		File personFile = mainApp.getPersonFilePath();
		if (personFile != null) {
			mainApp.savePersonDataToFile(personFile);
		} else {
			handleSaveAs();
		}
	}

	/**
	 * Opens a FileChooser to let the user select a file to save to.
	 */
	@FXML
	private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

		if (file != null) {
			// Make sure it has the correct extension
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			mainApp.savePersonDataToFile(file);
		}
	}

	/**
	 * Closes the application.
	 */
	@FXML
	private void handleExit() {
		System.exit(0);
	}
	  /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Maison Pour Tous");
        alert.setHeaderText("A propos");
        alert.setContentText("Author: Souhail Arhrabi \n"
        		+ "Maison Pour Tous est une application client lourd avec base de donné réalisé dans le cadre d'une évaluation CDI ");

        alert.showAndWait();
    }


	/**
	 *  Called when the user clicks the Representation Item. Opens the Representation view
	 *
	 */
	@FXML
	private void handleRepresentation() {
		mainApp.showRepresentation();
	}          
	
	/**
	 * Called when the user clicks the Adherant Item. Opens the Adherant view
	 * 
	 */
	@FXML
	private void handleAdherant() {
		mainApp.showAdherant();
	}          
	

}