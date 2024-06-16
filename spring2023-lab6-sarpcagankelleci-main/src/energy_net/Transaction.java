package energy_net;

public class Transaction {
	protected String id;
	protected EnergyRequest request;
	protected EnergyOffer offer;
	protected int tradedAmount;
	protected double price;
	
	public Transaction(EnergyRequest request, EnergyOffer offer, int tradedAmount, double price) {
		this.request = request;
		this.offer = offer;
		this.tradedAmount = tradedAmount;
		this.price = price;
		this.id = request.getID() + "_" + offer.getID();
	}
	
	public boolean equals(Object object) {
        if (this == object) 
        	return true;
        if (!(object instanceof Transaction)) 
        	return false;
        Transaction transaction1 = (Transaction) object;
        return (id.equals(transaction1.id));
    }
	
	public String toString() {
        return ("ID: " + id + "\nBuyer IP Address: " + request.owner.getIPAddress() + "\nSeller IP Address: " + offer.owner.getIPAddress() +
                "\nEnergy Amount: " + tradedAmount + "\nPrice =" + String.format("%.2f", price) + "\n");
    }

}
