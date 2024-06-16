package energy_net;

public class EnergyOffer extends EnergyOperation implements Comparable<EnergyOffer>{
	public double pricePerKilowatt;
	protected int distance;
	
	public EnergyOffer(Prosumer owner, int energyAmount, double pricePerKilowatt) {
	    super(owner, energyAmount);
	    this.pricePerKilowatt = pricePerKilowatt;
	    this.distance = owner.getDistance();
	}
	
	public double getPricePerKilowatt() {
        return pricePerKilowatt;
    }
	
	public String toString() {
        return ("Owner IP Address: " + owner.getIPAddress() + "\nEnergy Amount: " + getEnergyAmount() +
                "\nPrice: " + pricePerKilowatt + "\n");
    }


    @Override
    public int compareTo(EnergyOffer other) {
        if (this.pricePerKilowatt == other.pricePerKilowatt) {
        	int distance = owner.getDistance();
            return Integer.compare(this.distance, other.distance);
        } 
        else {
            return Double.compare(this.pricePerKilowatt, other.pricePerKilowatt);
        }
    }
}
