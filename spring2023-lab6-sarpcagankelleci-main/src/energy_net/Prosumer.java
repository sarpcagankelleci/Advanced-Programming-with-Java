package energy_net;

public class Prosumer extends Consumer {
	protected int distance;
	
	public Prosumer(String IP_address, String name, double balance) {
		super(IP_address, name, balance);
		this.distance = 10;
	}
	
	public Prosumer(String ip_address, String name, double balance, int distance) {
        super(ip_address, name, balance);
        this.distance = distance;
    }
	
	public void depositMoney(double amount) {
		if (amount >= 0) {
			addAmount(amount);
		}
	}
	
	public int getDistance() {
		return distance;
	}
	
	public String toString() {
		return (super.toString() + "Distance to center: " + distance + "\n");
	}
}
