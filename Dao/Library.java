package Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entities.Book;

public class Library {
	
	 private ArrayList<Book> books;

	    public Library() {
	        this.books = new ArrayList<>();
	    }

	
	
	
	 public void addBook(Book book) {
	        books.add(book);
	    }

	    public void displayBooks() {
	        for (Book book : books) {
	            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
	                    ", Available: " + (book.isAvailable() ? "Yes" : "No"));
	        }
	    }

	    public Book findBook(String title) {
	        for (Book book : books) {
	            if (book.getTitle().equalsIgnoreCase(title)) {
	                return book;
	            }
	        }
	        return null;
	    }




		public void getListOfLibraryLocations() {
			
			   Map<String, String> libraLocation = new HashMap<>();

		        // Adding key-value pairs to the map
			    libraLocation.put("Washington dc", "district of columbia");
			    libraLocation.put("Clifornia", "Sacramento");
			    libraLocation.put("Colorado", "denver");
			    libraLocation.put("Georgia ", "Atlanta");
			    libraLocation.put("Illinois", "SpringField");
			    libraLocation.put("Kensas", "Topoka");
			    libraLocation.put("Maryland", "Annapolis");
			    libraLocation.put("Levada", "Carson City");
			    libraLocation.put("Washington dc", "district of columbia");
			    libraLocation.put("Clifornia", "Sacramento");
			    libraLocation.put("Colorado", "denver");
			    libraLocation.put("Georgia ", "Atlanta");
			    libraLocation.put("Illinois", "SpringField");
			    libraLocation.put("Kensas", "Topoka");
			    libraLocation.put("Maryland", "Annapolis");
			    libraLocation.put("XXXX", "Carson City");

		     

		        // Iterating over the map
		        for (Map.Entry<String, String> entry : libraLocation.entrySet()) {
		             entry.getKey();
		            entry.getValue();
		            System.out.println(entry.getKey()+"     " + entry.getValue());
			    	
			
		}
	    

		}

}
