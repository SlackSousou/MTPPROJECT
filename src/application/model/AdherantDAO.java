package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import application.util.DBUtil;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class AdherantDAO {
    //*******************************
    //SELECT an Adherant
    //*******************************
    public static Adherant searchAdherant (String adherantId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM adherants WHERE ad_id="+adherantId;
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsAd = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getAdherantFromResultSet method and get adherant object
            Adherant adherant = getAdherantFromResultSet(rsAd);
 
            //Return adherant object
            return adherant;
        } catch (SQLException e) {
            System.out.println("While searching an adherant with " + adherantId + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }
  //Use ResultSet from DB as parameter and set adherant Object's attributes and return adherant object.
    private static Adherant getAdherantFromResultSet(ResultSet rs) throws SQLException{
    	Adherant ad =null;
    	if(rs.next()){
    		ad = new Adherant();
    		ad.setId(rs.getInt("adherant_id"));
    		ad.setNom(rs.getString("nom"));
    		ad.setPrenom(rs.getString("prenom"));
    		ad.setAdresse(rs.getString("adresse"));
    				
    		
    	}
    	return ad;
    }
    
  //*******************************
    //SELECT adherant
    //*******************************
    public static ObservableList<Adherant> searchAdherants () throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM adherants ORDER BY adherant_id ";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsAd = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getAdherantList method and get employee object
            ObservableList<Adherant> adList = getAdherantList(rsAd);
 
            //Return Adherantss object
            return adList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }
    
    //Select * from adherants operation
    private static ObservableList<Adherant> getAdherantList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of clients objects
        ObservableList<Adherant> adList = FXCollections.observableArrayList();
 
        while (rs.next()) {
            Adherant ad = new Adherant();
    		ad.setIdentifiant(rs.getInt("numAdherant"));
    		ad.setNom(rs.getString("nom"));
    		ad.setPrenom(rs.getString("prenom"));
    		ad.setAdresse(rs.getString("adresse"));
    	
            //Add adherant to the ObservableList
    		adList.add(ad);
        }
        //return adList (ObservableList of Adherant)
        return adList;
    }
 
  //*************************************
    //INSERT an Adherant
    //*************************************
    public static void insertAdherant( String nom, String prenom, String adresse) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
    	//Declare an INSERT statement
        String updateStmt =
                
                        "INSERT INTO adherants\n" +
                        "(nom, prenom, adresse)\n" +
                        "VALUES\n" +
                        "('"+nom+"', '"+prenom+"','"+adresse+"');\n"; 
                        
        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + updateStmt + "\n" + e);
            throw e;
        }
    }
    
    //*************************************
    //DELETE an client
    //*************************************
    public static void deleteAdherantWithId (String adherantId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Declare a DELETE statement
        String updateStmt =
                
                        "   DELETE FROM adherants\n" +
                        "         WHERE adherant_id ="+ adherantId +";\n"
                         ;
 
        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + updateStmt + "\n" + e);
            throw e;
        }
    }
    
  //*************************************
    //UPDATE an adherant informations
    //*************************************
    public static void updateAdherant (int adherantId, String nom, String prenom, String adresse ) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Declare an UPDATE statement
        String updateStmt =
                        "UPDATE adherants\n" +
                        "SET nom ='" + nom + "', prenom ='" + prenom + "', adresse ='" + adresse + "' \n" +
                        "WHERE adherant_id = " + adherantId + ";\n"
                        ; 
 
        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + updateStmt + "\n" + e);
            throw e;
        }
    }
       
    
}