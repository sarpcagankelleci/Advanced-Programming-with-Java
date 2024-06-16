package media;

public class Media {
	protected String mediaName;
	protected int mediaYear;
	protected Genre genre;
	
	public Media(String mediaName, int mediaYear, Genre genre) {
		this.mediaName = mediaName;
		this.mediaYear = mediaYear;
		this.genre = genre;
	}
	
	public String getMediaName(){
		return mediaName;
	}
	
	public int getMediaYear(){
		return mediaYear;
	}
	
	public Genre getGenre(){
		return genre;
	}
	
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}
	
	public void setMediaYear(int mediaYear) {
		this.mediaYear = mediaYear;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public String toString() {
		return ("Name : " + mediaName + "\n" + "Year : " + mediaYear + "\n" + "Genre : " + genre + "\n");
	}
	
	public String generateNotification() {
		return ("A new " + genre);
		
	}
	
	
	
	
}