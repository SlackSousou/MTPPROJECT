package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import application.util.DBUtil;
import application.view.PrincipaleViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RepresentationDAO {


	// Methode pour trouver un Representation en selection seulement les 
	public static ObservableList<Representation> ChercherRepresentationsListe () throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM representation, spectacle WHERE representation.numSpectacle = spectacle.numSpectacle";

		//Execute SELECT statement
		try {
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsRep = DBUtil.dbExecuteQuery(selectStmt);

			//Send ResultSet to the getRepresentationList method and get employee object
			ObservableList<Representation> repList = getRepresentationList(rsRep);


			//Return Representation object
			return repList;
			
			
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			//Return exception
			throw e;
		}
	}

	//Select * from Representation operation
	private static ObservableList<Representation> getRepresentationList(ResultSet rs) throws SQLException, ClassNotFoundException {
		//Declare a observable List which comprises of Representation objects
		ObservableList<Representation> repList = FXCollections.observableArrayList();

		  while (rs.next()) {
	            Representation rep = new Representation();
	            rep.setNumRepresentation((rs.getInt("numRepresentation")));
	            rep.setNomSpectacle(rs.getString("nomSpectacle"));
	            rep.setDateRepresentation(rs.getDate("dateRepresentation").toLocalDate());
	            rep.setTarif(rs.getDouble("tarif"));
	            //Add employee to the ObservableList
	            repList.add(rep);
	        }
	        //return repList (ObservableList of Employees)
	        return repList;
	    }
	public static void CalculTarif() {
		PrincipaleViewController.prixTotalField.setText(Double.toString((Integer.parseInt(PrincipaleViewController.nbrPersonneField.getText()) * Representation.tarif)));
		}

}