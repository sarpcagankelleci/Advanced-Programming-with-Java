package models;

public class Location {
	
	private int x_cord;
    private int y_cord;
    
    public Location(int x, int y) {
        this.x_cord = x;
        this.y_cord = y;
    }

    public int getX() {
        return x_cord;
    }

    public int getY() {
        return y_cord;
	
    }
    
    @Override
    public String toString() {
        return "Location (x = " + x_cord + ", y = " + y_cord + ")";
        
    }
    
    
}