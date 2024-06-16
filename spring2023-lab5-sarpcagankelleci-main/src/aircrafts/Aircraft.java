package aircrafts;

import java.util.ArrayList;

public abstract class Aircraft implements Flyable{
	
	protected static final ArrayList<Aircraft> aircraftList = new ArrayList<>();
	public String brandAndModel;
	public double aircraftPrice;
	public double totalFlightDistance;
	public double age;
	
	public double getAge() {
		return age;
	}
	
	public double setAge(double age) {
		return this.age = age;
	}
	
	public static int getAircraftQuantity() {
		return aircraftList.size();
	}
	
	public String getBrandAndModel() {
		return brandAndModel;
	}
	
	public double getAircraftPrice() {
		return aircraftPrice;
	}
	
	public double getTotalFlightDistance() {
		return totalFlightDistance;
	}
	
	public static ArrayList<Aircraft> getAircraftList(){
		return aircraftList;
	}
	
	public abstract void fly(double km);
	
	public Aircraft(String brandAndModel, double aircraftPrice) {
		if (aircraftPrice < 0) {aircraftPrice = 0;}
		this.aircraftPrice = aircraftPrice;
		
		if (brandAndModel.length() == 0 || brandAndModel == null) {brandAndModel = "Anonymous";}
		this.brandAndModel = brandAndModel;
		
		aircraftList.add(this);
	}
	
	public String toString() {
		return ("Name: " + brandAndModel + "\n" + "Price: " + aircraftPrice + "$" + "\n" + "Total Flight Distance: " + totalFlightDistance + "\n");
	}
 		
}


