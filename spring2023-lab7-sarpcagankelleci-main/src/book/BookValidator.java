package book;

import exception.InvalidBookException;
import exception.NoSuchBookException;
import java.util.Map;

public class BookValidator {
	
	public static void validateISBN(Book book) throws InvalidBookException {
	    String iSBN = book.getISBN();
	    
	    if (iSBN.length() != 13) { 
	    	throw new InvalidBookException("the length of the ISBN should be 13");}

	    if (!iSBN.matches("\\d+")) { 
	    	throw new InvalidBookException("the ISBN should contain only numeric characters");}
	}

	public static void validateExistence(Map<String, Book> books, String ISBN, String libraryName) throws NoSuchBookException {
	    if (!books.containsKey(ISBN)) { 
	    	throw new NoSuchBookException("the book with ISBN " + ISBN + " does not exist in the " + libraryName + " library");}
	    }
	}
