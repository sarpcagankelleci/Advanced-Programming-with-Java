package main;

import book.Book;
import book.BookValidator;
import exception.InvalidBookException;
import exception.InvalidLoanException;
import exception.NoSuchBookException;
import loan.Loan;
import loan.LoanValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

public class Library {
	public String name;
	public BookValidator bookValidator;
	public LoanValidator loanValidator;
	public Map<String, Book> books;
	public ArrayList<Loan> loans;
	
	public Library(String name) {
		this.name = name;
	    this.bookValidator = new BookValidator();
	    this.loanValidator = new LoanValidator();
	    this.books = new HashMap<>();
	    this.loans = new ArrayList<>();
	    }

	public void addBook(Book book) {
	    try {
	    	BookValidator.validateISBN(book);
	        books.put(book.getISBN(), book);
	        System.out.println("Book added: " + book.toString());
	        
	    } catch (InvalidBookException e) {
	        System.out.println(e.getMessage());
	        }
	    }

	public void borrowBook(String borrower, String ISBN, LocalDate dueDate) {
	    try {
	         BookValidator.validateExistence(books, ISBN, name);
	         Book book = books.get(ISBN);
	         
	         if (book.getIsAvailable()) {
	            	LoanValidator.validateDueDate(dueDate);
	            	
	                Loan loan = new Loan(borrower, book, dueDate, false);
	                book.setIsAvailable(false); 
	                loans.add(loan);
	                
	                System.out.println("Loan created: Barrower: " + borrower + ", Book: " + book.getTitle() 
	                					+ ", Due date: " + dueDate);
	        } else {
	        		LoanValidator.validateBookExistence(book);
	            }
	        } catch (NoSuchBookException e) {
	            System.out.println(e.getMessage());
	            
	        } catch (InvalidLoanException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	
	public Loan findLoanFromISBN(String ISBN) {
        for (Loan loan : loans) {
            if (!loan.getIsReturned() && loan.getBook().getISBN().equals(ISBN)) {
                return loan;
            }
        }
        return null;
    }

	public void returnBook(String ISBN) {
	    try {
	         BookValidator.validateExistence(books, ISBN, name);
	         Book book = books.get(ISBN);
	         Loan loan = findLoanFromISBN(ISBN);
	         if (loan != null) {
	        	 
	             loan.setIsReturned(true);
	             book.setIsAvailable(true);
	             System.out.println("Book returned: " + book.getTitle() + ", ISBN: " + ISBN);
	         } else {
	             System.out.println("No active loan found for book " + book.getTitle());
	            }
	        } catch (NoSuchBookException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	public void printAllLoans() {
	        System.out.println("All Loans:");
	        int count = 1;
	        for (Loan loan : loans) {
	            System.out.println("Loan " + count + ": Borrower: " + loan.getBarrower() + ", Book: " + loan.getBook().getTitle() 
	            			+ ", Due date: " + loan.getDueDate() + ", Returned: " + loan.getIsReturned());
	            count++;
	        }
	    }

	public void printMatchingBooks(String titlePattern) {
	        System.out.println("Matching books with '" + titlePattern + "':");
	        for (Book book : books.values()) {
	        	
	            if (book.getTitle().contains(titlePattern)) {
	                System.out.println("Book: " + book.getTitle() + ", ISBN: " + book.getISBN() + ", Author: " + book.getAuthor());
	            }
	        }
	    }
	
	public void printLibraryCatalog() {
        
        try (Formatter format = new Formatter(new PrintWriter("libraryCatalog.txt"))) {
        	System.out.println("Library Catalog:");
        	
            for (Book book : books.values()) {
            	String string;
                if (book.getIsAvailable()) {
                    string = String.format("Book Name: %s, ISBN: %s, Status: Available", book.getTitle(), book.getISBN());
                } else {
                    string = "Book Name: " + book.getTitle() + ", ISBN: " + book.getISBN() +
                            ", Status: On Loan - Borrower: " + findLoanFromISBN(book.getISBN()).getBarrower() +
                            ", Due Date: " + findLoanFromISBN(book.getISBN()).getDueDate();
                }
                System.out.println(string);
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("Error writing information into file: " + e.getMessage());
        }
    }
	
	
	}







