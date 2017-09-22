package application;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.sun.glass.ui.Application;

import application.model.Adherant;
import application.model.DataListWrapper;
import application.model.Representation;
import application.view.AdherantController;
import application.view.AdherantEditController;
import application.view.AdherantNewController;
import application.view.PrincipaleController;
import application.view.RepresentationController;
import application.view.RepresentationEditController;
import application.view.RepresentationNewController;
import application.view.RootLayoutController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;

	public Main() {

	}


	// The data as an observable list of Persons.

	private ObservableList<Representation> representationData = FXCollections.observableArrayList();
	private ObservableList<Adherant> adherantData = FXCollections.observableArrayList();

	//Returns the data as an observable list of representation .

	public ObservableList<Representation> getRepresentationData() {
		return representationData;
	}


	//Returns the data as an observable list of  adherant.

	public ObservableList<Adherant> getAdherantData() {
		return adherantData;
	}
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ToutBois");
		//this.primaryStage.setResizable(false);

		this.primaryStage.getIcons().add(new Image("images/logo-mpt-2017.png"));

		initRootLayout();
		showRepresentation();
		showAdherant();
		showPrincipaleOverView();
	}
	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application.view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Try to load last opened person file.

		/*File file = getPersonFilePath();
		if (file != null) {
			loadPersonDataFromFile(file);
		}
		 */
	}

	/**
	 *  Shows the principale inside the root layout.
	 */
	public void showPrincipaleOverView() {
		try {
			// Load principale view.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("View/PrincipaleOverView.fxml"));
			AnchorPane principale = (AnchorPane) loader.load();

			// Set principale view into the center of root layout.
			rootLayout.setCenter(principale);

			// Give the controller access to the main app.
			PrincipaleController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Shows the prospect inside the root layout.
	 */
	public void showAdherant() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application.view/Adherant.fxml"));
			AnchorPane adherant = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(adherant);

			// Give the controller access to the main app.
			AdherantController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Shows the new Client inside the root layout.
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public void showNewAdherant() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application.view/AdherantNew.fxml"));
			AnchorPane newAdherant = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(newAdherant);

			// Give the controller access to the main app.
			AdherantNewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}


	public boolean showAdherantEdit(Adherant adherant) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application/View/ProspectEdit.fxml"));
			AnchorPane newAdherant = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(newAdherant);

			// Give the controller access to the main app.
			AdherantEditController controller = loader.getController();
			controller.setAdherant(adherant);
			controller.setMainApp(this);
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Shows the represent inside the root layout.
	 */
	public void showRepresentation() {
		try {
			// Load representant view.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application.view/Representant.fxml"));
			AnchorPane representation = (AnchorPane) loader.load();

			// Set representant view into the center of root layout.
			rootLayout.setCenter(representation);

			// Give the controller access to the main app.
			RepresentationController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Shows the new Client inside the root layout.
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public void showNewRepresentation() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application.view/RepresentationNew.fxml"));
			AnchorPane newRepresentation = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(newRepresentation);

			// Give the controller access to the main app.
			RepresentationNewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	//////////////////////////////////////////

	public boolean showRepresentationEdit(Representation representation) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application/View/ProspectEdit.fxml"));
			AnchorPane newRepresentation = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(newRepresentation);

			// Give the controller access to the main app.
			RepresentationEditController controller = loader.getController();
			controller.setRepresentation(representation);
			controller.setMainApp(this);
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * Sets the file path of the currently loaded file. The path is persisted in
	 * the OS specific registry.
	 * 
	 * @param file
	 *            the file or null to remove the path
	 */
	public void setPersonFilePath(File file) {
		Preferences prefs = Preferences.userNodeForPackage(Main.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());

			// Update the stage title.
			primaryStage.setTitle("Tout Bois");
		} else {
			prefs.remove("filePath");

			// Update the stage title.
			primaryStage.setTitle("Tout Bois");
		}
	}

	/**
	 * Loads person data from the specified file. The current person data will
	 * be replaced.
	 * 
	 * @param file
	 */
/*public void loadPersonDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(DataListWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			// Reading XML from the file and unmarshalling.
			DataListWrapper wrapper = (DataListWrapper) um.unmarshal(file);

			representantData.clear();
			prospectData.clear();
			clientData.clear();
			representantData.addAll(wrapper.getRepresentant());
			prospectData.addAll(wrapper.getProspect());
			clientData.addAll(wrapper.getClient());

			// Save the file path to the registry.
			setPersonFilePath(file);

		} catch (Exception e) { // catches ANY exception
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not load data");
			alert.setContentText("Could not load data from file:\n" + file.getPath());

			alert.showAndWait();
		}
	}
*/
	/**
	 * Saves the current person data to the specified file.
	 * 
	 * @param file
	 */
	public void savePersonDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(DataListWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Wrapping our person data.
			DataListWrapper wrapper = new DataListWrapper();
			wrapper.setRepresentation(representationData);
			wrapper.setAdherant(adherantData);
			// Marshalling and saving XML to the file.
			m.marshal(wrapper, file);

			// Save the file path to the registry.
			setPersonFilePath(file);
		} catch (Exception e) { // catches ANY exception

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not save data");
			alert.setContentText("Could not save data to file:\n" + file.getPath());

			alert.showAndWait();
		}
	}

	/**
	 * Returns the person file preference, i.e. the file that was last opened.
	 * The preference is read from the OS specific registry. If no such
	 * preference can be found, null is returned.
	 * 
	 * @return
	 */
	public File getPersonFilePath() {
		Preferences prefs = Preferences.userNodeForPackage(Main.class);
		String filePath = prefs.get("filePath", null);

		if (filePath != null) {
			return new File(filePath);
		} else {
			return null;
		}
	}

	

	public static void main(String[] args) {
		launch(args);
	}

	
	
}