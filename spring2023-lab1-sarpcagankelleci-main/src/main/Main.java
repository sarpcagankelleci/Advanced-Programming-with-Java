package main;
import java.util.Scanner;

import hotcold.HotCold;
import hotcold.Player;

import java.security.SecureRandom;

public class Main {
	public static int getRandomNumber() {
		return new SecureRandom().nextInt(256);
	}

	public static void main(String[] args) {
		/**** Pledge of Honor*********

		I hereby certify that I have completed this lab assignment on my own without any help from anyone else. I understand that the only sources of authorized information in this lab assignment are (1) the course textbook, (2) the materials posted at the course website and (3) any study notes handwritten by myself. 
		I have not used, accessed or received any information from any other unauthorized source in taking this lab assignment. The effort in the assignment thus belongs completely to me. 
		READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID SIGNATURE: <Sarp Çağan Kelleci, 79482> ****************/
		
		Scanner input = new Scanner(System.in);

	    System.out.print("Enter the Player 1's name: ");  
	    String player1Name = input.nextLine();
	    
	    System.out.print("Enter the Player 2's name: ");
	    String player2Name = input.nextLine();
	    
	    System.out.print("Which option do you want? (1 for Euclidean, 2 for Manhattan) "); // 
	    int style = input.nextInt(); // 
	    
	    System.out.print("Enter the number of rounds: "); // input of the # of rounds
	    int rounds = input.nextInt(); // input rounds
	    
	    
		
		Player player1 = new Player(player1Name);
		Player player2 = new Player(player2Name);
		
		
		int x = getRandomNumber();
		int y = getRandomNumber();
	    
		
		

	    HotCold Game = new HotCold(player1, player2, x, y, rounds, style);

	    Game.play();
	    Game.whoWon();
	    
	    
	    		
	    }
		
	}

		    



