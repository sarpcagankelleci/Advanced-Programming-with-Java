package devices;
import media.Media;
import streaming.User;

public class Device {
	private static int idCounter = 0;
	protected User user;
	protected int id;
	public int numOfNotification = 1;
	
	public Device(User user) {
		this.id = idCounter++;
		this.user = user;
		this.user.userDevices.add(this);
	}
	
	public String notifyOwner(Media m, int numOfNotification) {
	    return ("--------------------------------------------------" + "\n" + "Hey there " + user.getUserName() + ",\n" + m.generateNotification());
	    }
	
	
}