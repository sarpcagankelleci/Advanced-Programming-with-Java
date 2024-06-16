package models;

public class Ship {
	
	private final String name;
    private double health;
    private Location location;
    private boolean isAlive;
    private final int xWidth;
    private final int yWidth;

    public Ship(String name, int xWidth, int yWidth) {
        this.name = name;
        this.health = 100.0;
        this.isAlive = true;
        this.xWidth = xWidth;
        this.yWidth = yWidth;
    }

    public void reduceHealth(double damage) {
        health = health - damage;
        if (health < 1) {
            this.isAlive = false;
        }
    }
    
    @Override
    public String toString() {
        return "Ship(name = " + name + ", isAlive = " + isAlive + ", health = " + health + ", "
        		+ "location = " + location.toString() + ", xwidth = " + xWidth + ", ywidth = " + yWidth + ")";
    }
    
    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
    	this.location = location;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getXWidth() {
        return xWidth;
    }

    public int getYWidth() {
        return yWidth;
    }

    
}