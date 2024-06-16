package hotcold;
import java.util.Scanner;

public class HotCold {
	private Player player1;
	private Player player2;
	private int xLocationToGuess;
	private int yLocationToGuess;
	private int rounds; // including round as instance variable
	private int style;
	
	public HotCold(Player player1, Player player2, int xLocationToGuess, int yLocationToGuess, int rounds, int style) { // adding rounds for the input of public method
		this.player1 = player1;
		this.player2 = player2;
		this.xLocationToGuess = xLocationToGuess;
		this.yLocationToGuess = yLocationToGuess;
		this.rounds = rounds; //setting rounds
		this.style = style; //setting style
		
	}
	public void play() {
		 int counter = 0;
		 while (counter < rounds) { // counter should be smaller than the number of rounds
		    counter = counter + 1;
			Scanner input = new Scanner(System.in);
			
			System.out.print(player1.getName() + " enter a number between 0 and 255 for the x location (both inclusive):");
		    int player1x = input.nextInt(); 
		    if (player1x < 0 || player1x > 255) {
	    		System.out.println("Wrong input is given. Try Again.");
	    	}
		    
		    System.out.print(player1.getName() + " enter a number between 0 and 255 for the y location (both inclusive):");
		    int player1y = input.nextInt(); 
		    if (player1y < 0 || player1y > 255) {
	    		System.out.println("Wrong input is given. Try Again.");
	    	}
		    
		    System.out.print(player2.getName() + " enter a number between 0 and 255 for the x location (both inclusive):"); 
		    int player2x = input.nextInt(); 
		    if (player2x < 0 || player2x > 255) {
	    		System.out.println("Wrong input is given. Try Again.");
	    	}
		    
		    System.out.print(player2.getName() + " enter a number between 0 and 255 for the y location (both inclusive):"); 
		    int player2y = input.nextInt(); 
		    if (player2y < 0 || player2y > 255) {
	    		System.out.println("Wrong input is given. Try Again.");
	    	}
		    
		    if (style == 1) {
		    	 double distance1 = Math.sqrt(Math.pow(xLocationToGuess - player1x, 2) + Math.pow(yLocationToGuess - player1y, 2));
				    
				 double distance2 = Math.sqrt(Math.pow(xLocationToGuess - player2x, 2) + Math.pow(yLocationToGuess - player2y, 2));	
		   
				System.out.printf("%s's distance is: %.3f\n", player1.getName(), distance1);
				System.out.printf("%s's distance is: %.3f\n", player2.getName(), distance2);
			    
			    if (distance1 < distance2) {
			    	player1.incrementTotalScore(distance1);
			    	System.out.println(player1.getName() + " won."); 
			    }
			    else if (distance1 == 0) {
			    	System.out.println("Location to guess was: x:" + xLocationToGuess + " y:" + yLocationToGuess + "." + player1.getName() + 
							"has won Hot and Cold with a total" + player1.getScore() + "points.");
			    	break;
			    }
			    else if (distance2 == 0) {
			    	System.out.println("Location to guess was: x:" + xLocationToGuess + " y:" + yLocationToGuess + "." + player2.getName() + 
							"has won Hot and Cold with a total" + player2.getScore() + "points.");
			    	break;
			    }
			    else if (distance2 < distance1) {
			    	player2.incrementTotalScore(distance2);
			    	System.out.println(player2.getName() + " won."); 
			    	
			    }
			    else {
			    	player1.incrementTotalScore(distance1);
			    	player2.incrementTotalScore(distance2);
			    	System.out.println(player1.getName()+ " and " + player2.getName() + " were the same distance to the location!");
			    }
		    	}
			 
			

		    if (style == 2) {
		    	 double distance1 = Math.abs(player1x - xLocationToGuess) + Math.abs(player1y -yLocationToGuess);
				    
				 double distance2 = Math.abs(player2x - xLocationToGuess) + Math.abs(player2y -yLocationToGuess);
				 
				System.out.printf("%s's distance is: %.3f\n", player1.getName(), distance1);
				System.out.printf("%s's distance is: %.3f\n", player2.getName(), distance2);
			    
			    if (distance1 < distance2) {
			    	player1.incrementTotalScore(distance1);
			    	player2.incrementTotalScore(distance2);
			    	System.out.println(player1.getName() + " won."); 
			    }
			    else if (distance1 == 0) {
			    	System.out.println("Location to guess was: x:" + xLocationToGuess + " y:" + yLocationToGuess + "." + player1.getName() + 
							"has won Hot and Cold with a total" + player1.getScore() + "points.");
			    	break;
			    }
			    else if (distance2 == 0) {
			    	System.out.println("Location to guess was: x:" + xLocationToGuess + " y:" + yLocationToGuess + "." + player2.getName() + 
							"has won Hot and Cold with a total" + player2.getScore() + "points.");
			    	break;
			    }
			    else if (distance2 < distance1) {
			    	player1.incrementTotalScore(distance1);
			    	player2.incrementTotalScore(distance2);
			    	System.out.println(player2.getName() + " won."); 
			    	
			    }
			    else {
			    	player1.incrementTotalScore(distance1);
			    	player2.incrementTotalScore(distance2);
			    	System.out.println(player1.getName()+ " and " + player2.getName() + " were the same distance to the location!");
			    }
		    	}
			 }
			}
	
	
	public void whoWon() {
		if (player1.getScore() > player2.getScore()) {
			System.out.println("Location to guess was: x:" + xLocationToGuess + " y:"  + yLocationToGuess + ". " + player1.getName() + 
					" has won Hot and Cold with a total " + player1.getScore() + " points.");
		}
		if (player2.getScore() > player1.getScore()) {
			System.out.println("Location to guess was: x:" + xLocationToGuess + " y:" + yLocationToGuess + ". " + player2.getName() + 
						" has won Hot and Cold with a total " + player2.getScore() + " points.");
		}
		
		if (player1.getScore() == player2.getScore()) {
			System.out.println("Hot and Cold between " + player1.getName() + " and " + player2.getName() + " resulted in a tie with both scoring " + player1.getScore() + " points." );
		}
		}
	}



