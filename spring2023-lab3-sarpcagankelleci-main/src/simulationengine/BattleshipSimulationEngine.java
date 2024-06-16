package simulationengine;

import java.util.Scanner;

import models.BattleshipArena;
import models.Location;
import models.Ship;
import java.security.SecureRandom;


public class BattleshipSimulationEngine {

	private boolean status;
	private BattleshipArena arena;
    
    /*
        As you know "this" keywod corresponds to the current object.
        Since we can return any object type from a method we can also return the current object itself.
        returning the reference of the current object allows us to chain functions back to back
        
        here we can do the following
	
	
        new BattleshipSimulationEngine().init().start();
        
        new BattleshipSimulationEngine() -> creates an instance of the object return its reference
        init() -> performs some operations and returns the same reference.
        
        
        if you catch the reference, you can access its methods like following.
        BattleshipSimulationEngine engine = new BattleshipSimulationEngine();
        engine.start()
        
        but you can do that without catching the reference, you can do it directly like new BattleshipSimulationEngine().start();
        but after that you lose the reference since start returns void.
        
        however init() function returns its reference again, we don't loose the reference after calling it.
        so new BattleshipSimulationEngine().init().start(); is possible.
        
        
    */
	// TODO: init enviroment add one ship
	public BattleshipSimulationEngine init() {
		this.status = true;
		
		arena = new BattleshipArena(30, 30);
		
		Location location1 = new Location(4, 12);
		Location location2 = new Location(5, 15);
		
		Ship ship1 = new Ship("ship1", 2, 2);
		Ship ship2 = new Ship("ship2", 3, 3);
		
		arena.addShip(ship1, location1);
		arena.addShip(ship2, location2);
		arena.drawArena();
		
		return this;

		
		/*SecureRandom random = new SecureRandom();
		
		int numOfShips = random.nextInt(5) + 1; 
		for (int i = 1; i <= numOfShips; i++) {
	        String nameOfShip = "Ship " + i + "";
	        
	        int widthOfShip = random.nextInt(5) + 1; 
	        int heightOfShip = random.nextInt(5) + 1;
	        
	        int xlocation = random.nextInt(arena.getXlength() - widthOfShip + 1); 
	        int ylocation = random.nextInt(arena.getYlength() - heightOfShip + 1); 
	        
	        Ship ship = new Ship(nameOfShip, widthOfShip, heightOfShip);
	        Location location = new Location(xlocation, ylocation);
	        arena.addShip(ship, location);
	    }
		arena.drawArena();
		
		return this;*/
	}
	

	public void start() {
		while (this.getStatus()) {
			this.update();
		}
		arena.showShipInfo();
	}
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	// TODO: implement this method
	public BattleshipSimulationEngine update() {
		Scanner cord = new Scanner(System.in);
		
		if (arena.getAliveShipCount() > 0) {
			
			System.out.println("Player X Location to fire: ");
			int x = cord.nextInt();
			
			System.out.println("Player Y Location to fire: ");
			int y = cord.nextInt();
			
			Location location = new Location(x,y);
			arena.attack(location);
			
		}
		else {
			
			this.status = false;
		}
		return this;
		
		/*if (arena.getAliveShipCount() > 0) {
		 
		SecureRandom coord = new SecureRandom(); 
		int x = coord.nextInt(arena.getXlength());
		int y = coord.nextInt(arena.getYlength());
		Location attackLocation = new Location(x, y);

		arena.attack(attackLocation);
		}

		else {
			
			this.status = false;
		}
		return this;
		}*/

	}
}

	
