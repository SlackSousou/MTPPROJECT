package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import application.util.DBUtil;
import javafx.collections.ObservableList;


public class RepresentationDAO {
    //*******************************
    //SELECT an Representation
    //*******************************
    public static Representation searchRepresentation (String representationId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Requette : (Selection Tout dans representations ou rep_id= )
        String selectStmt = "SELECT * FROM representations WHERE rep_id="+representationId;
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsRep = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getAdherantFromResultSet method and get representation object
            Representation representation = getRepresentationFromResultSet(rsRep);
 
            //Return representation object
            return representation;
        } catch (SQLException e) {
        	
        	//Requete : "Pour chercher un representer avec " represebtationId " id, une erreure s'est produite "
            System.out.println("While searching an representation with " + representationId + " id, an error occurred: " + e);
            
            //Return exception
            throw e;
        }
    }
  //Utilisez ResultSet de DB en tant que paramètre et définissez la représentation des attributs de l'objet et de l'objet de représentation de retour.
    private static Representation getRepresentationFromResultSet(ResultSet rs, String spectacleid) throws SQLException{
    	Representation rep =null;
    	if(rs.next()){
    		rep = new Representation();
    		rep.setDateRepresentation(rs.getDate("Date Representation"));
    	
    	
            String selectStmt = "SELECT * FROM spectacle WHERE spec_id="+ spectacleid;

    	}
    	return rep;
    }
    
    
    // Select Representation
    public static ObservableList<Representation> searchRepresentations () throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM representation ORDER BY representation_id ";
        String selectStmt1 = "SELECT * FROM spectacle ORDER BY nomSpectacle ";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsRep = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getRepresentationList method and get Representation object
            ObservableList<Representation> repList = getRepresentationList(rsRep);
 
            //Return Representation object
            return repList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }
    
 
  //*************************************
    //INSERT an Adherant
    //*************************************
    public static void selectRepresentation( LocalDate dateRepresentation, String nomSpectacle) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
    	//Declare an INSERT statement
        String updateStmt =
                
                        "SELECT INTO representations\n" +
                        "SELECT INTO spectacles\n" +

                        "(nom, prenom, adresse)\n" +
                        "VALUES\n" +
                        "('"+dateRepresentation+"', '"+nomSpectacle+"');\n"; 
                        
        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + updateStmt + "\n" + e);
            throw e;
        }
    }
       
    
}