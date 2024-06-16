package streaming;
import devices.Device;



public class FreeUser extends User {

    public FreeUser(String name) {
        super(name);
        
    }

    @Override
    public String postNotificationText(int numOfNotification) {
        return ("Download KuVPN now and get 10% off your next subscription.");
    }
}


