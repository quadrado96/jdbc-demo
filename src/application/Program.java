package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
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
		
		
		
		}

}
