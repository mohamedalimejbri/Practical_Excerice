package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import connection.MyConnection;

public class Commande {
	public void addCommande() throws ClassNotFoundException, SQLException 
	{ 
	double pricebook = 0;
	MyConnection con;
	PreparedStatement pstmt;
    con = new MyConnection();
    System.out.println("Put in the book's id ");
	Scanner sc1 = new Scanner( System.in );
	long idBook   = sc1.nextLong();
	System.out.println("Put in the quantity ");
	Scanner sc2 = new Scanner( System.in );
	int quantite   = sc2.nextInt();
	 try {
	        pstmt = con.MyConnec().prepareStatement("SELECT * FROM Book where id = ? "); 
	        pstmt.setDouble(1,idBook);
	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) 
	        	{
	        	 pricebook =Double.parseDouble(rs.getString("price"));
	        	}
	        }
	        catch(SQLException e)
	        {
	        	e.printStackTrace();
	        }
    pstmt =  con.MyConnec().prepareStatement("INSERT INTO `commande`(id,idbook,price,quantite,total) VALUES ( ?, ?, ?, ?,?)");
    pstmt.setNString(1, null );
    pstmt.setLong(2, idBook );
    pstmt.setDouble(3,pricebook);
    pstmt.setInt(4, quantite );
    pstmt.setDouble(5,pricebook*quantite );
	System.out.println("addition with success");
	pstmt.executeUpdate();
	}
	
	public void displayBill() throws ClassNotFoundException, SQLException 
	{   MyConnection con;
	PreparedStatement pstmt;
	double CalculTotal = 0;
    con = new MyConnection();
    try {
    pstmt = con.MyConnec().prepareStatement("SELECT * FROM commande "); 
    ResultSet rs = pstmt.executeQuery();
    int i=0;
    while (rs.next()) {
    	i++;
        System.out.println("Commande n°"+i);
        System.out.println("id : " + rs.getString("id")+" Idbook : " 
        + rs.getString("idbook")+" Price : " 
        + rs.getString("price")+" Quantite : " 
        + rs.getString("quantite")+" Total : " 
        + rs.getString("total"));
        CalculTotal =CalculTotal+Double.parseDouble(rs.getString("total"));         
    		}
    
	System.out.println("Total à payer = "+CalculTotal);
    	}
    catch(SQLException e)
    {e.printStackTrace();}
	 }
	
	
	public void deleteBill() throws ClassNotFoundException, SQLException
	{
		MyConnection con;
		PreparedStatement pstmt;
	    con = new MyConnection();
	    try {
            pstmt = con.MyConnec().prepareStatement("TRUNCATE TABLE commande ");
            pstmt.executeUpdate();
            }
            catch(SQLException e)
            {e.printStackTrace();}
		
	}
	
	
}
