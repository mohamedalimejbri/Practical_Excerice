package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.MyConnection;
import java.sql.Date;

public class Book 
{
	
	public void addBook(String title, String author, double price,Date releaseDate) throws ClassNotFoundException, SQLException 
	{ 
	MyConnection con;
	PreparedStatement pstmt;
    con = new MyConnection();
    
    pstmt =  con.MyConnec().prepareStatement("INSERT INTO `book`(id,title,author,price,releaseDate) VALUES (? , ?, ?, ?, ?)");
    pstmt.setNString(1, null );
    pstmt.setString(2, title );
    pstmt.setString(3, author );
    pstmt.setDouble(4,price);
    pstmt.setDate(5, releaseDate );
	System.out.println("addition with success");
	pstmt.executeUpdate();
	}
	
	public void displayBook() throws ClassNotFoundException, SQLException 
	{   MyConnection con;
	PreparedStatement pstmt;
    con = new MyConnection();
    try {
    pstmt = con.MyConnec().prepareStatement("SELECT * FROM Book "); 
    ResultSet rs = pstmt.executeQuery();
    int i=0;
    while (rs.next()) {
    	i++;
        System.out.println("Book n°"+i);
        System.out.println("id : " + rs.getString("id")+" Title : " 
        + rs.getString("title")+" Author : " 
        + rs.getString("author")+" Price : " 
        + rs.getString("price")+" ReleaseDate : " 
        + rs.getString("releaseDate"));
                       }
    	}
    catch(SQLException e)
    {e.printStackTrace();}
	 }
	
	
	
	
	public void deleteBook(long id) throws ClassNotFoundException, SQLException 
	{    MyConnection con;
		PreparedStatement pstmt;
		con = new MyConnection();
		try {
			pstmt = con.MyConnec().prepareStatement("DELETE FROM book WHERE id =?"); 
   
			pstmt.setLong(1,id);
			pstmt.executeUpdate();
			System.out.println("successful deletion");
			}
		catch(SQLException e)
			{e.printStackTrace();}	
	  }
	
	public void updateBook(String title, String author, double price,Date releaseDate,long id) throws ClassNotFoundException, SQLException 
	{   MyConnection con;
	PreparedStatement pstmt;
    con = new MyConnection();
    
    try {
    		pstmt = con.MyConnec().prepareStatement("UPDATE book SET title = ?,author = ?,price = ?,releaseDate = ? WHERE id = ?"); 
    		pstmt.setLong(6, id );
    		pstmt.setString(2, title );
    		pstmt.setString(3, author );
    		pstmt.setDouble(4,price);
    		pstmt.setDate(5, releaseDate );
    		pstmt.executeUpdate();
    	}
    
    catch(SQLException e)
    {
    	e.printStackTrace();}    	
	 }
	
}
