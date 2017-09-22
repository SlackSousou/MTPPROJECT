package application.view;

	import java.sql.SQLException;
	import java.util.regex.Pattern;

	import application.Main;
	import application.model.Adherant;
	import application.model.AdherantDAO;
	import application.model.Representation;
	import application.model.RepresentationDAO;
	import javafx.collections.ObservableList;
	import javafx.fxml.FXML;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Alert.AlertType;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.TextField;
	import javafx.stage.Window;

	public class AdherantEditController {



		@FXML
		private TextField nomField;
		@FXML
		private TextField prenomField;
		@FXML
		private TextField adresseField;
		

		private Main mainApp;
		private Adherant adherant;
		private boolean okClicked = false;

		/**
		 * Is called by the main application to give a reference back to itself.
		 * 
		 * @param mainApp
		 * @throws SQLException 
		 * @throws IllegalAccessException 
		 * @throws InstantiationException 
		 * @throws ClassNotFoundException 
		 */


		public void setMainApp(Main mainApp) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
			this.mainApp = mainApp;
			ObservableList<Representation> options =  RepresentationDAO.searchRepresentants();
			//numRepField.getItems().addAll(options);
			//numRepField.getSelectionModel().select(adherant.getNumRep()-1);
			// Add observable list data to the table

		} 	



		/**
		 * Returns true if the user clicked OK, false otherwise.
		 *
		 * @return
		 */
		public boolean isOkClicked() {
			return okClicked;
		}

		/**
		 * Called when the user clicks ok.
		 * @throws SQLException 
		 * @throws IllegalAccessException 
		 * @throws InstantiationException 
		 * @throws ClassNotFoundException 
		 * @throws NumberFormatException 
		 */
		@FXML
		private void handleOk() throws NumberFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
			//if (isInputValid()){
				
				//  String rep = numRepField.getValue().toString();
				//	String[] r = rep.split(" ");

			adherant.setNom(nomField.getText());
			adherant.setPrenom(prenomField.getText());
			adherant.setAdresse(adresseField.getText());


				okClicked = true;
				AdherantDAO.updateAdherant(adherant.getIdentifiant(),nomField.getText(), prenomField.getText(), adresseField.getText());
				mainApp.showAdherant();		}
		}	

		/**
		 * Called when the user clicks cancel.
		 */
		@FXML
		private void handleCancel() {
			mainApp.showAdherant();
		}

		/**
		 * Called when the user clicks cancel.
		 * @throws SQLException 
		 * @throws IllegalAccessException 
		 * @throws InstantiationException 
		 * @throws ClassNotFoundException 
		 */
		
		public void setAdherant(Adherant adherant) {
			this.adherant = adherant;

			nomField.setText(adherant.getNom());
			prenomField.setText(adherant.getPrenom());
			adresseField.setText(adherant.getAdresse());



		}

		@FXML
		private void handleLogo() {
			mainApp.showPrincipaleOverView();
		}
	/*	//teste l'email si correct
		public boolean isEmailValid(){
			if(Pattern.matches("^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+$",mailField.getText())){
				return true;
			}
			else{return false;}
		}
		//teste le numéro de tél
		public boolean isTelValid(){
			if(Pattern.matches("^([.0-9]+)+$",numTelField.getText())){
				return true;
			}
			else{return false;}
		}
		//teste si il y a bien 10 chiffres
		public boolean nbTelValid(){
			int i,j,valid = 0;
			char[] nbTel,j3;
			String j2="0123456789";
			nbTel = numTelField.getText().toCharArray();
			j3 = j2.toCharArray();
			for(j=0;j<10;j++){
				i = 0;
				for(i=0; i<numTelField.getText().length(); i++){
					if(nbTel[i] == j3[j]){
						valid = valid + 1;
					}	
				}
			}
			if(valid == 10){
				return true;
			}else{return false;}	
		}
		public boolean isSiretValid(){
			if(Pattern.matches("^([0-9]+)+$",siretField.getText())){
				return true;
			}
			else{return false;}
		} 
		//vérifie si les champs sont valide
		private boolean isInputValid() {
			String errorMessage = "";
			if (enseigneField.getText() == null || enseigneField.getText().length() == 0) {
				errorMessage += "Enseigne invalide!\n";
			}
			if (numRueField.getText() == null || numRueField.getText().length() == 0) {
				errorMessage += "Numero invalide!\n";
			}
			if (voieField.getText() == null || voieField.getText().length() == 0) {
				errorMessage += "Voie invalide!\n";
			}
			if (rueField.getText() == null || rueField.getText().length() == 0) {
				errorMessage += "Rue invalide!\n";
			}
			if (cPField.getText() == null || cPField.getText().length() == 0) {
				errorMessage += "Code postal invalide!\n";
			}
			if (villeField.getText() == null ||villeField.getText().length() == 0) {
				errorMessage += "Ville invalid invalide!\n";
			}
			if (mailField.getText() == null || mailField.getText().length() == 0 || isEmailValid() == false) {
				errorMessage += "Email invalide!\n";
			}
			if (numTelField.getText() == null || numTelField.getText().length() == 0 || isTelValid() == false || nbTelValid() == false) {
				errorMessage += "Téléphone invalide!\n" ;
			} 
			if (siretField.getText() == null || siretField.getText().length() !=14 || isSiretValid() == false) {
				errorMessage += "Siret invalide!\n";
			}
			if (paysField.getValue()==null){
				errorMessage += "Pays invalide!\n";
			}
			if (numRepField.getValue()==null){
				errorMessage += " Representant invalide!\n";
			}
			if (errorMessage.length() == 0) {
				return true;
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				Window dialogStage = null;
				alert.initOwner(dialogStage);
				alert.setTitle("Champ invalide");
				alert.setHeaderText("Veuillez remplir correctement les champs");
				alert.setContentText(errorMessage);
				alert.showAndWait();
				return false;
			}
		}
*/

	}
