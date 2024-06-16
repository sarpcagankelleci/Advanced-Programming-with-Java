package aircrafts;

import java.util.ArrayList;

public class Glider extends Aircraft{
	private static final ArrayList<Glider> gliderList = new ArrayList<>();
	private Plane helperPlane;
	public static final double MAX_AGE = 10;
	
	public Glider(String brandAndModel, double aircraftPrice, Plane helperPlane) {
		super(brandAndModel, aircraftPrice);
		this.helperPlane = helperPlane;
		gliderList.add(this);
		
	}
	
	public static int getGliderQuantity() {
		return gliderList.size();
	}
	
	public String toString() {
		return ("\n" + "Aircraft Type: Glider" + "\n" + super.toString() + "Helper Plane: " + 
				helperPlane.getBrandAndModel() + "\n");
				
		
	}

	@Override
	public void fly(double km) {
		if (km <= 0) {
			System.out.println("Distance must be positive !!");
		}
		else {
		double quarter = km / 4;
        double helperPlaneRange = helperPlane.getFuelAmount() * helperPlane.getFuelToRangeRatio();

        if (quarter <= helperPlaneRange) {
            helperPlane.fly(quarter);
            totalFlightDistance += quarter;
            System.out.println("\n" + "Glider " + getBrandAndModel() + " flew " + km + " kilometers.")
                    ;
        } else {
            System.out.println("\n" + "Glider " + getBrandAndModel() + " could not fly...");
        }
    }
	
	}
	
}
