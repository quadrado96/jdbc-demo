package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department d = new Department(1, "books");
		
		Seller s = new Seller(1, "kanye", "kanye@gmail.com", new Date(), 3000.0, d);
		
		System.out.println(s);
		System.out.println(d);
	}

}
