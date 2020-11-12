package bookstore;

import java.util.Scanner;

public class Principal {

	public static void main (String[]args)
	{ Calcul c = new Calcul();
		System.out.println("Put  the unit price ");
        Scanner sc2= new Scanner( System.in );
        Double price   = sc2.nextDouble();
		System.out.println("Put the quanity ");
        Scanner sc1= new Scanner( System.in );
        Double quantite   = sc1.nextDouble();
		
        System.out.println("Total :  "+c.calculateTotalPrice(quantite, price));


	}
}