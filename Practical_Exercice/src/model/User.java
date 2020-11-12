package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.MyConnection;

public class User {

	
	
	public void addUser(String nom, String prenom, long telephone, String email) throws ClassNotFoundException, SQLException 
	{ 
	MyConnection con;
	PreparedStatement pstmt;
    con = new MyConnection();
    
    pstmt =  con.MyConnec().prepareStatement("INSERT INTO `user`(id,nom,prenom,telephone,email) VALUES (? , ?, ?, ?, ?)");
    pstmt.setNString(1, null );
    pstmt.setString(2, nom );
    pstmt.setString(3, prenom );
    pstmt.setLong(4,telephone);
    pstmt.setString(5, email );
	System.out.println("addition with success");
	pstmt.executeUpdate();
	}
	
	
	
	
	public void displayUser() throws ClassNotFoundException, SQLException 
	{   MyConnection con;
	PreparedStatement pstmt;
    con = new MyConnection();
    try {
    pstmt = con.MyConnec().prepareStatement("SELECT * FROM User "); 
    ResultSet rs = pstmt.executeQuery();
    int i=0;
    while (rs.next()) {
    	i++;
        System.out.println("User n°"+i);
        System.out.println("id : " + rs.getString("id")+" Nom : " 
        + rs.getString("nom")+" Prenom : " 
        + rs.getString("prenom")+" Telephone : " 
        + rs.getString("telephone")+" Email : " 
        + rs.getString("email"));
                       }
    	}
    catch(SQLException e)
    {e.printStackTrace();}
	 }
	
	
	
	
	public void deleteUser(long id) throws ClassNotFoundException, SQLException 
	{    MyConnection con;
		PreparedStatement pstmt;
		con = new MyConnection();
		try {
			pstmt = con.MyConnec().prepareStatement("DELETE FROM user WHERE id =?"); 
   
			pstmt.setLong(1,id);
			pstmt.executeUpdate();
			System.out.println("successful deletion");
			}
		catch(SQLException e)
			{e.printStackTrace();}	
	  }
	
	
	
	public void updateUser(String nom, String prenom, long telephone,String email,long id) throws ClassNotFoundException, SQLException 
	{   MyConnection con;
	PreparedStatement pstmt;
    con = new MyConnection();
    
    try {
    		pstmt = con.MyConnec().prepareStatement("UPDATE user SET nom = ?,prenom = ?,telephone = ?,email = ? WHERE id = ?"); 
    		pstmt.setLong(6, id);
    		pstmt.setString(2, nom);
    		pstmt.setString(3, prenom);
    		pstmt.setLong(4,telephone);
    		pstmt.setString(5, email);
    		pstmt.executeUpdate();
    	}
    
    catch(SQLException e)
    {
    	e.printStackTrace();}    	
	 }
	
	
}
