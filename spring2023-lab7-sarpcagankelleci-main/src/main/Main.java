package main;
/**** Pledge of Honor*********

I hereby certify that I have completed this lab assignment on my own without any help from anyone else. 
I understand that the only sources of authorized information in this lab assignment are (1) the course textbook, (2) the materials posted at the course website and (3) any study notes handwritten by myself. 
I have not used, accessed or received any information from any other unauthorized source in taking this lab assignment. 
The effort in the assignment thus belongs completely to me. 
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID SIGNATURE: <Sarp Çağan Kelleci, 79482> ****************/

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

// Import necessary classes

import book.Book;
import book.BookValidator;
import exception.InvalidBookException;
import exception.InvalidLoanException;
import exception.NoSuchBookException;
import loan.Loan;
import loan.LoanValidator;


public class Main {
    public static void main(String[] args) throws NoSuchBookException {
        // Create a library
    	Library library = new Library("MyLibrary");

    	File input = new File("src/main/Input.txt");
    	
    		try {
    			Scanner scanner = new Scanner(input);

    	        while (scanner.hasNextLine()) {
    	                String line = scanner.nextLine();
    	                String[] bookInfo = line.split(" ");
    	                if (line != "") {
    	                	if (bookInfo.length == 5) {
    	                		String ISBN = bookInfo[0];
    	                		String title = bookInfo[1] + " " + bookInfo[2];
    	                		String author = bookInfo[3] + " " + bookInfo[4];
    	                		boolean isAvailable = true;

    	                		Book book = new Book(ISBN, title, author, isAvailable);
    	                		library.addBook(book);
    	                   
    	                	} else {
    	                		System.out.println("Invalid book information: " + line);
    	                }
    	            }
    	        }
    	        
    	 System.out.println();
    	 library.borrowBook("Fatma", "1234567890123", LocalDate.parse("2023-06-05"));
    	 library.borrowBook("Vahideh", "2345678901234", LocalDate.parse("2023-06-10"));
    	 library.borrowBook("Sarp", "123456789012X", LocalDate.parse("2023-06-11"));
    	 library.borrowBook("Sarp", "1111111111111", LocalDate.parse("2023-06-11"));
    	 library.borrowBook("Sarp", "3456789012345", LocalDate.parse("2019-01-01"));
    	 
    	 System.out.println();
    	 System.out.println("Inlab - Task1");
    	 library.borrowBook("Sarp2", "1234567890123", LocalDate.parse("2023-06-05"));
    	 System.out.println();
    	 library.returnBook("1234567890123");
//    	 library.returnBook("2345678901234");
    	 library.returnBook("1111111111111");
    	 
    	 scanner.close();
    	        } catch (FileNotFoundException e) {
    	 System.out.println("Input file not found.");
    	        }

    	 System.out.println();

    	 library.printAllLoans();

    	 System.out.println();

    	 library.printMatchingBooks("Programming");
    	 
    	 System.out.println();
    	 System.out.println("InLab - Task2");
         library.printLibraryCatalog();
    	 
    	    }
    	}
