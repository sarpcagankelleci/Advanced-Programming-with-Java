package aircrafts;

public class FueledAircraft extends Aircraft implements Refuelable  {
	
	public double fuelTankCapacity;
	public double fuelAmount;
	public double fueltoRangeRatio;
	
	public FueledAircraft(String brandAndModel, double aircraftPrice, double fuelTankCapacity, double fuelAmount, double fueltoRangeRatio) {
		super(brandAndModel, aircraftPrice);
		
		if (fuelTankCapacity < 10) {fuelTankCapacity = 10;}
		this.fuelTankCapacity = fuelTankCapacity;
		
		if (fuelAmount < 0) {fuelAmount = 0;}
		if (fuelAmount > fuelTankCapacity) {fuelAmount = fuelTankCapacity;}
		this.fuelAmount = fuelAmount;
		
		if (fueltoRangeRatio < 1) {fueltoRangeRatio = 1;}
		this.fueltoRangeRatio = fueltoRangeRatio;
	}
	
	public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelToRangeRatio() {
        return fueltoRangeRatio;
    }
	@Override
	public void fly(double km) {
		if (km <= 0) {
			System.out.println("Fueled Aircraft input is invalid !!");
		}
		else {
			double maximumRange = fuelAmount * fueltoRangeRatio;
			
			if (km <= maximumRange) {
				fuelAmount -= km / fueltoRangeRatio;
				
				totalFlightDistance += km;
				
				System.out.printf("\nFueled Aircraft %s flew %.2f kilometers, %.2f liters of fuel left.\nFueled Aircraft Current Range: %.2f kilometers\n",
				                brandAndModel, km, fuelAmount, fuelAmount * fueltoRangeRatio);
			}
			else if (fuelAmount == 0){
				
				System.out.printf("\nFueled Aircraft %s could not fly... %.2f liters of fuel left.\nFueled Aircraft Current Range: %.2f kilometers\n",
		                brandAndModel, fuelAmount, fuelAmount * fueltoRangeRatio);
				
			}
				
			else {
				
				System.out.printf("\nFueled Aircraft %s could only fly %.2f kilometers, ", brandAndModel, fuelAmount * fueltoRangeRatio);
				fuelAmount = 0;
				System.out.printf("%.2f liters of fuel left.\nFueled Aircraft Current Range: %.2f kilometers\n", fuelAmount, fuelAmount * fueltoRangeRatio);

				
			}
		}

		
	}
	public String toString() {
		double maximumRange = fuelTankCapacity * fueltoRangeRatio;
		double currentRange = fuelAmount * fueltoRangeRatio;
		
		return (super.toString() + "Max Range: " + maximumRange + " kms" + "\n" + "Current Fuel Level: " + fuelAmount + " liters" + "\n"  + "Current Range: " + currentRange + " kms");
			  
	}

	@Override
	public void refuel(double addedFuelAmount) {
		if (addedFuelAmount < 0) {
			System.out.println("Refuel tank level input is invalid !!");
		}
	
		if (addedFuelAmount > 0 && addedFuelAmount < fuelTankCapacity) {
			fuelAmount += addedFuelAmount;
			 System.out.printf("\nFueled Aircraft %s's tank is refueled! Added: %.2f liters of fuel!\nFueled Aircraft %s's Current Range: %.2f kms\n", 
					 brandAndModel, fuelAmount, brandAndModel, fuelTankCapacity * fueltoRangeRatio);
		}
		if (addedFuelAmount >= fuelTankCapacity) {
			fuelAmount = fuelTankCapacity;
			System.out.printf("\nFueled Aircraft %s's tank is refueled! Added: %.2f liters of fuel!\nFueled Aircraft %s's Current Range: %.2f kms\n", 
					 brandAndModel, fuelAmount, brandAndModel, fuelTankCapacity * fueltoRangeRatio);
        } 
        
       
    }

		
	} 
	


