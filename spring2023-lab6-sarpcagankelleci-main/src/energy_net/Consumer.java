package energy_net;

public class Consumer {
	protected String IP_address;
	protected String name;
	protected double balance;
	
	public Consumer(String IP_address, String name, double balance) {
		this.IP_address = IP_address;
		this.name = name;
		this.balance = balance;
	}
	
	public String getIPAddress() {
		return IP_address;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void addAmount(double amount) {
		if (amount >= 0) {
			balance += amount;
		}
	}
	
	public boolean deductAmount(double amount) {
	     if (balance >= amount && amount >= 0) {
	    	 balance -= amount;
	         return true;
	     } 
	     else {
	         return false;
	     }
	}
	
	public boolean equals(Object object1) {
        if (object1 instanceof Consumer) {
            Consumer object = (Consumer) object1;
            return IP_address.equals(object.IP_address);
        }
        return false;
    }
	
	public int getDistance() {
		return getDistance();
	}
	
	
	public String toString() {
	    return String.format("Name: %s\nIP Address: %s\nBalance: %.2f\n", name, IP_address, balance);
	}

	


}
