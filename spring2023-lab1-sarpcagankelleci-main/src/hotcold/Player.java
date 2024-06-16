package hotcold;

public class Player {
	
	private String playerName;
	private int guessedLocationx;
	private int guessedLocationy;
	private double totalScore;
	private int xLocationToGuess;
	private int yLocationToGuess;
	
	public Player(String name) {
		
		int guessedLocationx = -1;
		int guessedLocationy = -1;
		double totalScore = 0;
		playerName = name;
		
	}
	
	public int getNumberx() {
		return guessedLocationx;
	}
	
	public void setNumberx(int guessedLocationx) {
		this.guessedLocationx = guessedLocationx;
	}
	public int getNumbery() {
		return guessedLocationy;
	}
	
	public void setNumbery(int guessedLocationy) {
		this.guessedLocationy = guessedLocationy;
		
	}
	public double getScore() {
		return totalScore;
	}
	public String getName() {
		return playerName;
	}
		
	public void incrementTotalScore(double distancea) { //
		
		totalScore = totalScore + (1 / distancea) * 100;
	}

}
