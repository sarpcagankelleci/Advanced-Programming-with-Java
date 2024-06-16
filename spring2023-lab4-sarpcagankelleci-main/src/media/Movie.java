package media;


public class Movie extends Media {
	private String directorName;
	private int durationHour;
	private int durationMinutes;
	
	public Movie(String mediaName, int mediaYear, Genre genre, String directorName, int durationHour, int durationMinutes) {
		super(mediaName, mediaYear, genre);
		this.directorName = directorName;
		this.durationHour = durationHour;
		this.durationMinutes = durationMinutes;
	}
	
	public String toString() {
		return (super.toString() + "Director : " + directorName + "\n" + "Duration : " + durationHour + " hours " + durationMinutes + " minutes " + "\n" + 
				"--------------------------------------------------");
	}
	
	public String generateNotification() {
		return (super.generateNotification() + " movie is added to our platform." + "\n" + "We thought you might like it!" + "\n" +
				"--------------------------------------------------" + "\n" + "Movie Information:" + "\n" + this.toString());
	}
}
