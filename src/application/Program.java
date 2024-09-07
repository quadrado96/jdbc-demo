package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDeparmentDao();
		
		boolean x = true;
		while (x) {
			System.out.println("Select a table: "
					+ "\n1.Seller"
					+ "\n2.Departement");
			int table = sc.nextInt();
			sc.nextLine();
			
			switch (table) {
			case 1:
				System.out.println("Choose an operation: "
						+ "\n1.Insert"
						+ "\n2.Update"
						+ "\n3.delete by id"
						+ "\n4.find by id"
						+ "\n5.find by department"
						+ "\n6.find all.");
				int sellerOperation = sc.nextInt();
				sc.nextLine();
				switch (sellerOperation) {
				case 1: 
					System.out.println("Type data to insert: (Name, Email, BirthDate, BaseSalary, DepartmentId)");
					String name = sc.nextLine();
					String email = sc.nextLine();
					Date birthDate = sdf.parse(sc.nextLine());
					Double baseSalary = sc.nextDouble();
					Integer departmentId = sc.nextInt();
					sc.nextLine();
					
					Department department = departmentDao.findById(departmentId);
					
					Seller newSeller = new Seller(null, name, email, birthDate, baseSalary, department);
					sellerDao.insert(newSeller);
					break;
					
				case 2: 
					System.out.println("Type data to update: (Name, Email, BirthDate, BaseSalary, DepartmentId)");
					name = sc.nextLine();
					email = sc.nextLine();
					birthDate = sdf.parse(sc.nextLine());
					baseSalary = sc.nextDouble();
					departmentId = sc.nextInt();
					sc.nextLine();
					
					department = departmentDao.findById(departmentId);
					
					System.out.println("Enter the seller id: ");
					int id = sc.nextInt();
					sc.nextLine();
					newSeller = new Seller(id, name, email, birthDate, baseSalary, department);
					sellerDao.update(newSeller);
					break;
					
				case 3: 
					System.out.println("Enter an id for deletion: ");
					id = sc.nextInt();
					
					sellerDao.deleteById(id);
					break;
				
				case 4: 
					System.out.println("Enter an id to search: ");
					id = sc.nextInt();
					
					System.out.println(sellerDao.findById(id));
					break;
					
				case 5: 
					System.out.println("Enter an department to search: (id/name) ");
					Integer depId = sc.nextInt();
					String depName = sc.nextLine();
					department = new Department(depId, depName);
					List<Seller> list = sellerDao.findByDepartment(department);
					for (Seller obj : list) {
						System.out.println(obj);
					}
					break;
					
				case 6: 
					list = sellerDao.findAll();
					for (Seller obj: list) {
						System.out.println(obj);
					}
					break;
					}
				break;
				
			case 2:
				System.out.println("Choose an operation: "
						+ "\n1.Insert"
						+ "\n2.Update"
						+ "\n3.delete by id"
						+ "\n4.find by id"
						+ "\n5.find all.");
				
				int departmentOperation = sc.nextInt();
				switch (departmentOperation) {
				case 1:
					System.out.println("Type data to insert: (Id/name)");
					Integer id = sc.nextInt();
					sc.nextLine();
					String name = sc.nextLine();
			
					Department newDepartment = new Department(id,name);
					departmentDao.insert(newDepartment);
					break;
				
				case 2:
					System.out.println("Type data to update: ");
					id = sc.nextInt();
					name = sc.nextLine();
					
					newDepartment = new Department(null,name);
					departmentDao.update(newDepartment);
					break;
					
				case 3: 
					System.out.println("Enter an id for deletion: ");
					id = sc.nextInt();
					
					departmentDao.deleteById(id);
					break;
				
				case 4: 
					System.out.println("Enter an id to search: ");
					id = sc.nextInt();
					
					System.out.println(departmentDao.findById(id));;
					break;
					
				case 5:
					
					List<Department> list = departmentDao.findAll();
					for (Department obj: list) {
						System.out.println(obj);
					}
					break;
				}
				break;

			}
			
			System.out.print("Do you want to continue? (y/n) ");
			char answer = sc.next().charAt(0);
			if (answer == 'n') {
				x = false;
			}
		}
		
		sc.close();
		}
	
}
