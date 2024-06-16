package devices;
import media.Media;
import streaming.User;


public class PersonalComputer extends Device {
	
	public PersonalComputer(User user) {
        super(user);
    }
	
	public String notifyOwner(Media m, int numOfNotification) {
		this.numOfNotification++;
        return (super.notifyOwner(m, numOfNotification) + "\n" + "Watch it now on your PersonalComputer device with the id:" + id + "\n"
        		+ user.postNotificationText(numOfNotification) + "\n" + "--------------------------------------------------");
    }
	
}
