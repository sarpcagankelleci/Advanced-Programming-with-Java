package models;

 
public class BattleshipArena {

	private char[][] xySpace;
	private Ship[] shipList;
	private static int shipcounter = 0;
	private int xlength;
	private int ylength;
	// TODO: initialize instance variables in the constructor
	public BattleshipArena(int xlength, int ylength) {
		this.xlength = xlength;
		this.ylength = ylength;
		
		shipList = new Ship[10];
		
		this.xySpace = new char[xlength][ylength];
		
		initXYspace(this.xySpace, '.');
		
		
		

	}

	public void drawArena() {
		for (int j = 0; j < ylength; j++)
			System.out.print("-");
		
		System.out.println("-> y axis columns");
		
		for (int i = 0; i < xlength; i++) {
			System.out.print("|");
			
			for (int j = 0; j < ylength; j++) {
				
				System.out.print(xySpace[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("v");
		
		System.out.println("x axis rows");
	}

	// TODO: implement xyspace initializer
	private void initXYspace(char[][] xySpace, char pattern) {
		for (int i = 0; i < xlength; i++) {
			
			for (int k = 0; k < ylength; k++) {
				
				xySpace[i][k] = pattern;
			}
		}
		
	}

	// TODO: implement addShip method
	public boolean addShip(Ship ship, Location location) {
		if (shipcounter == this.shipList.length) {
			System.out.println("Unable to add ship.");
			return false;
		}
		
		else {
			if (isLocationsValid(location)) {
				if (ship.getXWidth() + location.getX() < xlength && ship.getYWidth() + location.getY() < ylength) {
					for (int i = location.getX(); i < location.getX() + ship.getXWidth(); i++) {
						for(int j = location.getY(); j < location.getY() + ship.getYWidth(); j++) {
							if (this.xySpace[i][j] == 'S') {
								System.out.println("Unable to add ship.");
								return false;
							}
						}
					}
					ship.setLocation(location);
					shipList[shipcounter++] = ship;
	
					for (int i = location.getX(); i < location.getX() + ship.getXWidth(); i++) {
						for(int j = location.getY(); j < location.getY() + ship.getYWidth(); j++) {
							xySpace[i][j] = 'S';
						}
						
					}
					
				}
			}
			return true;
		}
		
	}

	// TODO: implement attack method
		public boolean attack(Location location) {
			boolean check = true;
			if (isLocationsValid(location)) {
				
				for (int i = 0; i < shipcounter; i++) {
					
					if (isHit(location)!= null) {
						
						Ship attackedShip = isHit(location);
						xySpace[location.getX()][location.getY()] = 'X';
						attackedShip.reduceHealth(calculateHitDemage(attackedShip));
						System.out.println("Hit!! The ship has " + attackedShip.getHealth() + " percent health left! Is ship alive: " + attackedShip.isAlive());
						drawArena();
						
						check = false;
						
					}
					
					}
				
			if (check) {
				System.out.println("Miss!");
					
				}
				
			}
			return check;

		}

	// TODO: print status of the ships by calling their toString method.
	public void showShipInfo() {
		
		for (int i = 0; i < shipcounter; i++) {
			
			System.out.println(shipList[i]);
		}

	}

	private double calculateHitDemage(Ship ship) {
		
		return (100.0 / ((ship.getXWidth()) * (ship.getYWidth())));
	}

	// TODO: check if there's a ship on the given location
			private Ship isHit(Location location) {
				
				if (xySpace[location.getX()][location.getY()] == 'S') {
					
					for (int i = 0; i < shipcounter; i++) {
						
						if (isLocationHitsTheShip(shipList[i],location)) {
							
							return shipList[i];
						}
					}
				}
				return null;
			}

	// TODO: check if the location hits the given ship
			private boolean isLocationHitsTheShip(Ship ship, Location location) {
				
				if (ship.getLocation().getX() <= location.getX()){
					if (location.getX() < ship.getLocation().getX() + ship.getXWidth()){
						if (ship.getLocation().getY() <= location.getY()) {
							if (location.getY() < ship.getLocation().getY() + ship.getYWidth()) {
								return true;	
						}
						}
					}
					
					
					}
				return false;
			}

	
	// TODO: check if the given location exceeds our simulation space
		public boolean isLocationsValid(Location location) {
			
			if (location.getX() >= xlength || location.getY() >= ylength) {
				
				return false;
			}
			
			return true;
		}

	// TODO: return alive ship count
		public long getAliveShipCount() {
			
			int result = 0;
			
			for (int i = 0; i < shipcounter; i++) {
				
				if (shipList[i].isAlive()) {
					
					result++;
				}
			}
			return result;
		}
		
		public int getXlength() {
	        return xlength;
	    }
		
		public int getYlength() {
	        return ylength;
	    }


}