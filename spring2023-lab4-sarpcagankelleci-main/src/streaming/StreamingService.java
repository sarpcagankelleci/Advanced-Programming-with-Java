package streaming;
import media.*;
import devices.*;

import java.util.ArrayList;

public class StreamingService {
    protected ArrayList<Media> medias;
    protected ArrayList<User> users;

    public StreamingService() {
        medias = new ArrayList<Media>();
        users = new ArrayList<User>();
    }
    
    public void addMedia(Media m) {
        for (Media media : medias) {
            if (media.getMediaName().equals(m.getMediaName())) {
                System.err.println("Error!! A media with the same name already in the list!" + "\n");
                return;
            }
        }
        medias.add(m);
        System.out.println("Media added to the Streaming Service " + "\n");
       
    }
    
    public void addUser(User u) {
    	for(User user : users) {
    		if (user.getUserName().equals(u.getUserName())) {
    			System.err.println("Error!! A user with the same name already in the list!" + "\n");
                break;
    		}
    	}
    	users.add(u);
    	 System.out.println("User added to the Streaming Service " + "\n");
    	
    }
    
    public void notifyAllUsers() {
    	
    	for (User user: users) {
    		ArrayList<Genre> likedGenres = user.getLikedGenres();
            ArrayList<Device> devices = user.getDevices();
            
            for (Media media : medias) { 
                if (likedGenres.contains(media.getGenre())) { 
                    media.generateNotification();
                    
                    for (Device device : devices) { 
					System.out.println(device.notifyOwner(media, device.numOfNotification));
                    }        
                    
    	}
    	
    }
    
   }
    }
}