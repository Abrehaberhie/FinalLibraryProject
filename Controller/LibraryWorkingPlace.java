package Controller;

import java.util.Scanner;

import Dao.EmployeeDAO;
import Dao.Library;
import Dao.userDao;
import entities.Book;
import entities.Employee;
import entities.User;



public class LibraryWorkingPlace {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        
        
        
        

        // Adding books to the library
        library.addBook(new Book("A Tele of Two cities", "charles Dickens"));
        library.addBook(new Book("The litle prince", "Antonine desaint"));
        library.addBook(new Book("and then there were none", "Agatha christ"));
        library.addBook(new Book("she: a history of adventure","H.Rider Haggerd"));
        library.addBook(new Book("Lolita","viadmir Nabokov"));
        library.addBook(new Book("Black beauty","Anna Sewell"));
        library.addBook(new Book("Anne of Green Gables","Lucy Maud"));
      
        
       User user = new User();
            
           while(true) {
            System.out.println("We are very happy to see you in our libary!");
            System.out.println("If you want to see the available books please 'A'");
            System.out.println("If you want to borrow a book please press     'B'");
            System.out.println("If you want to return the book please Press   'c'");
            System.out.println("If you want to see our Users please enter       'D'");
            System.out.println("if you want to see people who work in the library press   'E'");
            System.out.println("if you want to see our library locations pleaase press 'F'");
            System.out.println("If you want to exit from our system please press 'G'");
            System.out.print("Enter your choice: ");
            char choice = scanner.next().charAt(0);

	            switch (choice) {
	                case 'A':
	                    library.displayBooks();
	                    break;
	                case 'B':
	                    System.out.print("Give me the tile of the book you want to borrow please.");
	                    scanner.nextLine(); // Consume newline
	                    String borrowTitle = scanner.nextLine();
	                    Book borrowBook = library.findBook(borrowTitle);
	                    if (borrowBook != null && borrowBook.isAvailable()) {
	                        System.out.println("You can borrowed the book: please return it on time " + borrowBook.getTitle());
	                        borrowBook.setAvailable(false);
	                    } else {
	                        System.out.println("The book is not available in the store please come back another time");
	                    }
	                    break;
	                case 'C':
	                    System.out.print("Enter the title of the book you want to return: ");
	                    scanner.nextLine(); // Consume newline
	                    String returnTitle = scanner.nextLine();
	                    Book returnBook = library.findBook(returnTitle);
	                    if (returnBook != null && !returnBook.isAvailable()) {
	                        System.out.println("Thank you for returning the book: " + returnBook.getTitle());
	                        returnBook.setAvailable(true);
	                    } else {
	                        System.out.println("Invalid book or book is already available.");
	                    }
	                    break;
	                case 'D':

	                 	scanner.nextLine();
	                	System.out.println("data about user");
	        	        userDao userDao = new userDao();

	        	        while (true) {
	        	            System.out.println("Choose an option:");
	        	            System.out.println("1. Create user");
	        	            System.out.println("2. Read user by ID");
	        	            System.out.println("3. Update user");
	        	            System.out.println("4. Delete user");
	        	            System.out.println("5. get All user");
	        	            System.out.println("5. Exit");
	        	            System.out.print("Enter your choice: ");

	        	           int option = scanner.nextInt();
	        	            scanner.nextLine(); 

	        	            switch (option)
	        	            {
	        	                case 1:
	        	                
	        	                	 
	        	                    System.out.println("enter your id");
	        	                    int id =  scanner.nextInt();
	        	                    System.out.print("Enter name: ");
	        	                    String name = scanner.next();
	        	                    System.out.print("Enter age: ");
	        	                    int age = scanner.nextInt();
	        	                    System.out.print("Enter salary: ");
	        	                    double rating = scanner.nextDouble();
	        	                    User newUser = new User();
	        	                    
	        	                    newUser.setId(id);
	        	                    newUser.setName(name);
	        	                    newUser.setAge(age);
	        	                    newUser.setRating(rating);
	        	                    if (userDao.createUser(newUser)) {
	        	                        System.out.println("User created successfully.");
	        	                    } else {
	        	                        System.out.println("Failed to create employee.");
	        	                    }
	        	                	
	        	                    break;
	        	                case 2:
	        	                	 
	        	                    System.out.print("Enter User ID: ");
	        	                    int usid = scanner.nextInt();
	        	                    User retrievedUser = userDao.getUserById(usid);
	        	                    if (retrievedUser != null) {
	        	                        System.out.println("User details:");
	        	                        System.out.println("ID: " + retrievedUser.getId());
	        	                        System.out.println("Name: " + retrievedUser.getName());
	        	                        System.out.println("Age: " + retrievedUser.getAge());
	        	                        System.out.println("Rating: " + retrievedUser.getRating());
	        	                    } else {
	        	                        System.out.println("User not found.");
	        	                    }
	        	                	 
	        	                    break;
	        	                case 3:
	        	                	
	        	                    System.out.print("Enter employee ID to update: ");
	        	                    int updateId = scanner.nextInt();
	        	                    scanner.nextLine(); 
	        	                    User updateUser = userDao.getUserById(updateId);
	        	                    
	        	                    if (updateUser != null) {
	        	                        System.out.print("Enter new name: ");
	        	                        String newName = scanner.next();
	        	                        System.out.print("Enter new age: ");
	        	                        int newAge = scanner.nextInt();
	        	                        System.out.print("Enter new salary: ");
	        	                        double newRating = scanner.nextDouble();
	        	                        updateUser.setName(newName);
	        	                        updateUser.setAge(newAge);
	        	                        updateUser.setRating(newRating);
	        	                        if (userDao.updateUser(updateUser)) {
	        	                            System.out.println("User updated successfully.");
	        	                        } else {
	        	                            System.out.println("Failed to update user.");
	        	                        }
	        	                    } else {
	        	                        System.out.println("user not found.");
	        	                    }
	        	                	
	        	                    break;
	        	                case 4:
	        	                    System.out.print("Enter user ID to delete: ");
	        	                    int deleteId = scanner.nextInt();
	        	                    scanner.nextLine(); 
	        	                    if (userDao.deleteUser(deleteId)) {
	        	                        System.out.println("User deleted successfully.");
	        	                    } else {
	        	                        System.out.println("Failed to delete user.");
	        	                    }
	        	                    break;
	        	                case 5:
	        	                	System.out.println(userDao.getAllUser());
	        	                    break;
	        	                case 6:
	        	                    System.out.println("Exiting...");
	        	                    System.exit(0);
	        	                    break;
	        	               
	        	                default:
	        	                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
	        	            
	        	            }
	        	            break;
	        	            
	        	        }break;
	        	        
	            
	                case 'E':
	                	scanner.nextLine();
	                	System.out.println("data about imployee");
	        	        EmployeeDAO employeeDAO = new EmployeeDAO();

	        	        while (true) {
	        	            System.out.println("Choose an option:");
	        	            System.out.println("1. Create Employee");
	        	            System.out.println("2. Read Employee by ID");
	        	            System.out.println("3. Update Employee");
	        	            System.out.println("4. Delete Employee");
	        	            System.out.println("5. get All Employee");
	        	            System.out.println("5. Exit");
	        	            System.out.print("Enter your choice: ");

	        	           int option = scanner.nextInt();
	        	            scanner.nextLine(); 

	        	            switch (option)
	        	            {
	        	                case 1:
	        	                
	        	                	 
	        	                    System.out.println("enter your id");
	        	                    int id =  scanner.nextInt();
	        	                    System.out.print("Enter name: ");
	        	                    String name = scanner.next();
	        	                    System.out.print("Enter age: ");
	        	                    int age = scanner.nextInt();
	        	                    System.out.print("Enter salary: ");
	        	                    double salary = scanner.nextDouble();
	        	                    Employee newEmployee = new Employee();
	        	                    
	        	                    newEmployee.setId(id);
	        	                    newEmployee.setName(name);
	        	                    newEmployee.setAge(age);
	        	                    newEmployee.setSalary(salary);
	        	                    if (employeeDAO.createEmployee(newEmployee)) {
	        	                        System.out.println("Employee created successfully.");
	        	                    } else {
	        	                        System.out.println("Failed to create employee.");
	        	                    }
	        	                	
	        	                    break;
	        	                case 2:
	        	                	 
	        	                    System.out.print("Enter employee ID: ");
	        	                    int impid = scanner.nextInt();
	        	                    Employee retrievedEmployee = employeeDAO.getEmployeeById(impid);
	        	                    if (retrievedEmployee != null) {
	        	                        System.out.println("Employee details:");
	        	                        System.out.println("ID: " + retrievedEmployee.getId());
	        	                        System.out.println("Name: " + retrievedEmployee.getName());
	        	                        System.out.println("Age: " + retrievedEmployee.getAge());
	        	                        System.out.println("Salary: " + retrievedEmployee.getSalary());
	        	                    } else {
	        	                        System.out.println("Employee not found.");
	        	                    }
	        	                	 
	        	                    break;
	        	                case 3:
	        	                	
	        	                    System.out.print("Enter employee ID to update: ");
	        	                    int updateId = scanner.nextInt();
	        	                    scanner.nextLine(); 
	        	                    Employee updateEmployee = employeeDAO.getEmployeeById(updateId);
	        	                    
	        	                    if (updateEmployee != null) {
	        	                        System.out.print("Enter new name: ");
	        	                        String newName = scanner.next();
	        	                        System.out.print("Enter new age: ");
	        	                        int newAge = scanner.nextInt();
	        	                        System.out.print("Enter new salary: ");
	        	                        double newSalary = scanner.nextDouble();
	        	                        updateEmployee.setName(newName);
	        	                        updateEmployee.setAge(newAge);
	        	                        updateEmployee.setSalary(newSalary);
	        	                        if (employeeDAO.updateEmployee(updateEmployee)) {
	        	                            System.out.println("Employee updated successfully.");
	        	                        } else {
	        	                            System.out.println("Failed to update employee.");
	        	                        }
	        	                    } else {
	        	                        System.out.println("Employee not found.");
	        	                    }
	        	                	
	        	                    break;
	        	                case 4:
	        	                    System.out.print("Enter employee ID to delete: ");
	        	                    int deleteId = scanner.nextInt();
	        	                    scanner.nextLine(); 
	        	                    if (employeeDAO.deleteEmployee(deleteId)) {
	        	                        System.out.println("Employee deleted successfully.");
	        	                    } else {
	        	                        System.out.println("Failed to delete employee.");
	        	                    }
	        	                    break;
	        	                case 5:
	        	                	System.out.println(employeeDAO.getAllEmployees());
	        	                    break;
	        	                case 6:
	        	                    System.out.println("Exiting...");
	        	                    System.exit(0);
	        	                    break;
	        	               
	        	                default:
	        	                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
	        	            
	        	            }
	        	            break;
	        	            
	        	        }break;
	        	        
	            
	                	
                               
           
	                case 'F':
	                	scanner.nextLine();
	                	System.out.println("here are list of our library locations");
	                	library.getListOfLibraryLocations();
	                	break;
	                	 	
	                case 'G':
	                    System.out.println("You are leaving our library. Goodbye!");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            
	        }
	    
           }
           
	}

}
	


