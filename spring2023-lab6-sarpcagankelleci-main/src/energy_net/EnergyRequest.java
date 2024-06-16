package energy_net;

public class EnergyRequest extends EnergyOperation {
	protected String preferredIPAddress;
	protected EnergyPreference preference;
	
	public EnergyRequest(Consumer owner, int energyAmount, EnergyPreference preference) {
		super(owner, energyAmount);
		this.preference = preference;
    }

    public EnergyRequest(Consumer owner, int energyAmount, String preferredIpAddress) {
        super(owner, energyAmount);
        this.preferredIPAddress = preferredIpAddress;
        this.preference = EnergyPreference.LOW_PRICE;
 
    }
    
    public EnergyRequest(Consumer owner, int energyAmount, String preferredIpAddress, EnergyPreference preference) {
        super(owner, energyAmount);
        this.preferredIPAddress = preferredIpAddress;
        this.preference = preference;
    }

    public String getPreferredIpAddress() {
        return preferredIPAddress;
    }
    
    public EnergyPreference getPreference() {
    	return preference;
    }
    
    public String toString() {
        String preferredIPString = preferredIPAddress != null ? preferredIPAddress : "null";
        return ("Owner IP Address :" + owner.getIPAddress() + "\nEnergy Amount: " + getEnergyAmount() + "\nPreferred IP: " + preferredIPString + "\nPreference: " + preference
        			+ "\n");
//        return String.format("Owner IP Address: %s\nEnergy Amount: %d\nPreferred IP: %s\nPreference: \n", owner.getIPAddress(),
//                getEnergyAmount(), preferredIPString, preference);
    }
}
