package energy_net;


public abstract class EnergyOperation {
	 protected static int incrementedID = 0;
	 protected final int id;   
	 protected final Consumer owner;
	 protected int energyAmount;

	 public EnergyOperation(Consumer owner, int energyAmount) {
	    this.id = ++incrementedID;
	    this.owner = owner;
	    this.energyAmount = energyAmount;
	 }
	 
	 public void decreaseEnergyAmount(int amount) {
	        energyAmount -= amount;
	 }
	 
	 public int getID() {
		 return id;
	 }
	 
	 public int getEnergyAmount() {
		 return energyAmount;
	 }
	 
}
