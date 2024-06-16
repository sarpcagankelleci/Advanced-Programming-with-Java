package streaming;

import java.util.ArrayList;
import media.*;
import devices.*;

public class User {
	private String userName;
	protected ArrayList<Genre> likedGenres;
	public ArrayList<Device> userDevices;
	
	public User(String userName) {
        this.userName = userName;
        this.likedGenres = new ArrayList<Genre>();
        this.userDevices = new ArrayList<Device>();
    }
    
    public String getUserName() {
        return userName;
    }
    
    public ArrayList<Genre> getLikedGenres() {
        return likedGenres;
    }
    
    public ArrayList<Device> getDevices() {
        return userDevices;
    }
    
    public void likeGenre(Genre g) {
        if (!likedGenres.contains(g)) {
            likedGenres.add(g);
        }
    }
    
    public void unlikeGenre(Genre g) {
        likedGenres.remove(g);
    }
    
    public void removeDevice(Device d) {
        userDevices.remove(d);
    }
    
    public String postNotificationText(int numOfNotification) {
    	return ("Download KuVPN now and get 10% off your next subscription.");
    	
    }
	
}