package application.util;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;
 
public class DBUtil {
    //Declare JDBC Driver
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
 
    //Connection
    private static Connection conn = null;
 
    //Connection String
    //String connStr = "jdbc:oracle:thin:Username/Password@IP:Port/SID";
    //Username=HR, Password=HR, IP=localhost, IP=1521, SID=xe
    private static final String connStr = "jdbc:mysql://localhost:3306/maisonpourtous";
 
     
    //Fonction Permettant de se connecté a la base de donné
    public static void dbConnect() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Setting Oracle JDBC Driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Mysql JDBC Driver?");
            e.printStackTrace();
            throw e;
        }
 
        System.out.println("Mysql JDBC Driver Registered!");
 
        //Establish the Mysql Connection using Connection String
        try {
            conn = DriverManager.getConnection(connStr,"root","");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            e.printStackTrace();
            throw e;
        }
    }
 
    //Close Connection
    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e){
           throw e;
        }
    }
 
    //Fonction permettant d'envoyer les requette SQL
    public static ResultSet dbExecuteQuery(String ma_requete) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Declare statement, resultSet and CachedResultSet as null
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            dbConnect();
            System.out.println("Select statement: " + ma_requete + "\n");
 
            //Create statement
            stmt = conn.createStatement();
 
            //Execute select (query) operation
            resultSet = stmt.executeQuery(ma_requete);
 
            //CachedRowSet Implementation
            //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
            //We are using CachedRowSet
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                //Close resultSet
                resultSet.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
        //Return CachedRowSet
        return crs;
    }
 
    //Fonction permettant d'envoyer les modif de mes requel SQL
    public static void dbExecuteUpdate(String ma_requete_de_modif) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Declare statement as null
        Statement stmt = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            dbConnect();
            //Create Statement
            stmt = conn.createStatement();
            //Run executeUpdate operation with given sql statement
            stmt.executeUpdate(ma_requete_de_modif);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                //Close statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
    }
}