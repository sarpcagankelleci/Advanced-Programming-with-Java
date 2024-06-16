package loan;

import java.time.LocalDate;

import book.Book;
import exception.InvalidLoanException;

public class LoanValidator {
	public static void validateDueDate(LocalDate dueDate) throws InvalidLoanException {
		LocalDate current = LocalDate.now();
		
		if (dueDate.isBefore(current)) {
			throw new InvalidLoanException("the due date should be a future date ");
		}
		
	}
	
	public static void validateBookExistence(Book book) throws InvalidLoanException {
		
		if (!book.getIsAvailable()) {
            throw new InvalidLoanException("the book with ISBN " + book.getISBN() + 
            								" is not available for loan.");
        }
	}
}

