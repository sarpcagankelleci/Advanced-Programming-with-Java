package media;

public class Series extends Media {
	private String networkName;
	private int seasonDuration;
	private int episodeDuration;
	
	public Series(String mediaName, int mediaYear, Genre genre, String networkName, int seasonDuration, int episodeDuration) {
		super(mediaName, mediaYear, genre);
		this.networkName = networkName;
		this.seasonDuration = seasonDuration;
		this.episodeDuration = episodeDuration;
	}
	
	public String toString() {
		return(super.toString() + "Network : " + networkName + "\n" + "Duration :" + seasonDuration + " seasons and " + episodeDuration + " episodes" + "\n" 
				+ "--------------------------------------------------");
	}
	public String generateNotification() {
		return (super.generateNotification() + " series is added to our platform." + "\n" + "We thought you might like it!" + "\n" +
				"--------------------------------------------------" + "\n" + "Series Information:" + "\n" + this.toString());
	}
	

}