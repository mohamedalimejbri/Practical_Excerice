package model;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Pricipal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome in our application ");
		Book book = new Book();
		User user = new User();
		Commande commande = new Commande();
		byte choix=0;
		do 
		{
		
		System.out.println("what do you want to do? ");
		System.out.println("1:Add book ");
		System.out.println("2:Delete book ");
		System.out.println("3:Update book ");
		System.out.println("4:Place an order ");
		System.out.println("5:Display bill ");
		System.out.println("6:Display all the books ");
		System.out.println("7:Add user ");
		System.out.println("8:Delete user ");
		System.out.println("9:Update user ");
		System.out.println("10:Display all the users ");
		System.out.println("11:Exit ");

		Scanner sc3 = new Scanner( System.in );
		choix   = sc3.nextByte();
		switch(choix) {
		  case 1:
		  	{	
			System.out.println("Put in the book's title ");
			Scanner sc = new Scanner( System.in );
			String title   = sc.nextLine();
			System.out.println("Put in the book's author ");
			Scanner sc1 = new Scanner( System.in );
			String author   = sc1.nextLine();
			System.out.println("Put in the book's price ");
			Scanner sc2 = new Scanner( System.in );
			double price   = sc2.nextDouble();	
			System.out.println("enter the release date of the book TO UPDATE (yyyy-mm-dd)");
            Scanner sc5 = new Scanner( System.in );
            String doj=sc5.next();
            Date releasedate=java.sql.Date.valueOf(doj);
			book.addBook(title, author, price, releasedate);
				break;
			}
		  case 2:
		  	{
			  book.displayBook();	
			  System.out.println("Put in book's id ");
				Scanner sc = new Scanner( System.in );
				long id   = sc.nextLong();
				book.deleteBook(id);
				break;
			}
		  case 3:
		  {
			  System.out.println("Put in the book's title ");
			Scanner sc4 = new Scanner( System.in );
			long id   = sc4.nextLong();
			  System.out.println("Put in the book's title ");
			Scanner sc = new Scanner( System.in );
			String title   = sc.nextLine();
			System.out.println("Put in the book's author ");
			Scanner sc1 = new Scanner( System.in );
			String author   = sc1.nextLine();
			System.out.println("Put in the book's price ");
			Scanner sc2 = new Scanner( System.in );
			double price   = sc2.nextDouble();	
			System.out.println("enter the release date of the book TO UPDATE (yyyy-mm-dd)");
          Scanner sc5 = new Scanner( System.in );
          String doj=sc5.next();
          Date releasedate=java.sql.Date.valueOf(doj);
			book.updateBook(title, author, price, releasedate, id);
			break;}
		  case 4:
		  {		int r;
		  		do	 
			  		{book.displayBook();
			  		commande.addCommande();
			  		System.out.println("If you wanna exit put 2 ");
			  		Scanner sc2 = new Scanner( System.in );
			  		 r = sc2.nextInt();}
				while(r!=2);
			  break;
				}
		  case 5:
		  {
			  commande.displayBill();
			  commande.deleteBill();
				break;
			}
		  case 6:
		  {
			  book.displayBook();
				break;
			}
		  case 7:
		  {
			  System.out.println("Put in the user's name ");
			Scanner sc = new Scanner( System.in );
			String name   = sc.nextLine();
			System.out.println("Put in the user's firstname ");
			Scanner sc1 = new Scanner( System.in );
			String firstname   = sc1.nextLine();
			System.out.println("Put in the user's telephone ");
			Scanner sc2 = new Scanner( System.in );
			long telephone   = sc2.nextLong();	
			System.out.println("Put in the user's email ");
			Scanner sc5 = new Scanner( System.in );
			String email   = sc5.nextLine();
				user.addUser(name, firstname, telephone, email);
			break;}
		  case 8:
		  {
			 user.displayUser();	
		  System.out.println("Put in user's id ");
			Scanner sc = new Scanner( System.in );
			long id   = sc.nextLong();
			book.deleteBook(id);
			break;
				}
		  case 9:
		  {System.out.println("Put in the user's name ");
			Scanner sc = new Scanner( System.in );
			String name   = sc.nextLine();
			System.out.println("Put in the user's firstname ");
			Scanner sc1 = new Scanner( System.in );
			String firstname   = sc1.nextLine();
			System.out.println("Put in the user's telephone ");
			Scanner sc2 = new Scanner( System.in );
			long telephone   = sc2.nextLong();	
			System.out.println("Put in the user's email ");
			Scanner sc5 = new Scanner( System.in );
			String email   = sc5.nextLine();
			System.out.println("Put in user's id ");
			Scanner sc6 = new Scanner( System.in );
			long id   = sc6.nextLong();
				user.updateUser(name, firstname, telephone, email,id);
			break;
				}
		  case 10:
		  {
			  user.displayUser();
				break;
		   }
		}
		
		}
		while (choix!=11);

			
		System.out.println("Good bye");
		
		
		
	}

}
