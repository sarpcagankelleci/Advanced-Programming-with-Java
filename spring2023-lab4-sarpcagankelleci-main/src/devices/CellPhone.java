package devices;
import media.Media;
import streaming.User;

public class CellPhone extends Device {
	
	public CellPhone(User user) {
        super(user);
    }
	
	public String notifyOwner(Media m, int numOfNotification) {
		this.numOfNotification++;
        return (super.notifyOwner(m, numOfNotification) + "\n" + "Watch it now on your CellPhone device with the id:" + id + "\n"
        		+  user.postNotificationText(numOfNotification) +  "\n" + "--------------------------------------------------");
    }
	
	
}