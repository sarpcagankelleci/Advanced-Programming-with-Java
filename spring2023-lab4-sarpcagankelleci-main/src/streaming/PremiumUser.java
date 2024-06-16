package streaming;
import devices.Device;



public class PremiumUser extends User {
	private int sumOfNotifications;

    public PremiumUser(String name) {
        super(name);
        this.sumOfNotifications = 0;
        
    }

    @Override
    public String postNotificationText(int numOfNotification) {
    	sumOfNotifications += numOfNotification;
    	return "You have " + numOfNotification + " notification.";
    }
    }



