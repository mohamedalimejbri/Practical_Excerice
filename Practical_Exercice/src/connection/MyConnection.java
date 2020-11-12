package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
Connection c =null;
    
    public MyConnection() throws ClassNotFoundException, SQLException
    {
         
    }

	public Connection MyConnec() throws SQLException, ClassNotFoundException
	{
		// chargement du pilote spécifique au pilote de BD (soit ODBC ou Driver personnalisé du SGBD):
        Class.forName("com.mysql.jdbc.Driver");
        
        // Définition du contexte de la connection (URL de la connection):
        String url = "jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC";
        // récuperer une réference vers la connexion à la base de données (source de données) en question :
        c = DriverManager.getConnection(url,"root","");
        
		return c;}

	
}