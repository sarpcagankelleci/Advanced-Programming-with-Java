package aircrafts;

import java.util.ArrayList;

public class Plane extends FueledAircraft {
	
	private static final ArrayList<Plane> planeList = new ArrayList<>();
	public static final double MAX_AGE = 20;
	
	public Plane(String brandAndModel, double aircraftPrice, double tank, double fuel, double ratio) {
		super(brandAndModel, aircraftPrice, tank, fuel, ratio);
		planeList.add(this);
	}
	
	public static int getPlaneQuantity() {
		return planeList.size();
	}
	
	public String toString() {
		return ( "\n" + "Aircraft Type: Plane" + "\n" + super.toString());
	}

	

}
