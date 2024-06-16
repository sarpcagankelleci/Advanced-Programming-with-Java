package book;

public class Book {
	protected String iSBN;
	protected String title;
	protected String author;
	protected boolean isAvailable;
	
	public Book(String iSBN, String title, String author, boolean isAvailable) {
		this.iSBN = iSBN;
		this.title = title;
		this.author = author;
		this.isAvailable = isAvailable;
	}
	
	public String getISBN() {
		return iSBN;
	}
	
	public boolean getIsAvailable() {
		return isAvailable;
	}

	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

	public String toString() {
		return (" " + title + ", ISBN: " + iSBN + ", Author: " + author);
		
	}
}
