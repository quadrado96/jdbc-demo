package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---------- TEST seller findById -------");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		
		System.out.println("\n---------- TEST 2 seller findByDepartment -------");
		Department dep = new Department(2, "Eletronics");
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n---------- TEST 3 seller findAll -------");
		
		list = sellerDao.findAll();
		for (Seller obj: list) {
			System.out.println(obj);
		}
		

		System.out.println("\n---------- TEST 4 seller insert -------");
		
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new Id= " + newSeller.getId());
	
		System.out.println("\n---------- TEST 5 seller insert -------");
		seller = sellerDao.findById(1);
		seller.setName("Bruce Wayne");
		sellerDao.update(seller);
		System.out.println("Update done!");
		
		System.out.println("\n---------- TEST 6 seller delete -------");
		System.out.println("Enter id for deletion: ");
		sellerDao.deleteById(sc.nextInt());
		System.out.println("Delete completed!");
		
		
		sc.close();
		}
	
	

}
