package loan;

import java.time.LocalDate;

import book.Book;

public class Loan {
	protected String barrower;
	protected Book book;
	protected LocalDate dueDate;
	protected boolean isReturned;
	
	public Loan(String barrower, Book book, LocalDate dueDate, boolean isReturned) {
		this.barrower = barrower;
		this.book = book;
		this.dueDate = dueDate;
		this.isReturned = isReturned;
	}
	
	public Book getBook() {
		return book;
	}

	public boolean getIsReturned() {
		return isReturned;
	}

	public void setIsReturned(boolean boolean1) {
		this.isReturned = boolean1;
	}
	
	public String getBarrower() {
		return barrower;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}
	
	
}
