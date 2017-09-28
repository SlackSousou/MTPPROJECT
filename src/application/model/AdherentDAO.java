package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import application.util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AdherentDAO {


	// Methode pour trouver un Adherent en selection seulement les 
	public static ObservableList<Adherent> ChercherAdherentsListe () throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM adherent ORDER BY numAdherent ";

		//Execute SELECT statement
		try {
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsAd = DBUtil.dbExecuteQuery(selectStmt);

			//Send ResultSet to the getAdherantList method and get employee object
			ObservableList<Adherent> adList = getAdherentList(rsAd);

			//Return Adherantss object
			return adList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			//Return exception
			throw e;
		}
	}
	//Select * from Adherents operation
	private static ObservableList<Adherent> getAdherentList(ResultSet rs) throws SQLException, ClassNotFoundException {
		//Declare a observable List which comprises of Adherents objects
		ObservableList<Adherent> adList = FXCollections.observableArrayList();

		while (rs.next()) {
			Adherent ad = new Adherent();
			ad.setIdentifiant(rs.getInt("numAdherent"));
			ad.setNom(rs.getString("nomAdherent"));
			ad.setPrenom(rs.getString("prenomAdherent"));

			//Add Adherent to the ObservableList
			adList.add(ad);
		}
		//return adList (ObservableList of Adherent)
		return adList;
	}
	

}