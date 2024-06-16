# IMPORTANT

For each lab assignment, **you must include and sign (by writing your name and student id number) the following Pledge of Honor statement at the beginning of your main method source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**
```
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Name Surname, Student id>
********************************************************************************/
```
## IMPORTANT NOTE 2: After you complete the tasks, do not forget to commit your changes and push them to your repository on Github.

## IMPORTANT NOTE 3: This README.md file only contains the instructions for PRELAB. You will also have INLAB questions.

# COMP 132: Advanced Programming

## Spring 2023: Lab-1 - Hot and Cold Game

Using the object-oriented programming concepts covered so far, you are asked to implement a game application named Hot and Cold for two players. The application generates a random x and y location between 0-255 for the whole game session. The players try to guess the generated location, and the player with the closest guess wins a round and gains points based on some criteria, which are explained below. The whole Hot and Cold game will be played for 3 rounds. Afterward, the name of the player with the highest score is printed on the screen.

Inside the given Java project, you should create a package named hotcold and a class named Player inside the package.

# Player Class

## Instance Variables:

```java
String playerName;
int guessedLocationx;
int guessedLocationy;
int totalScore;
```

## Public methods:

Define the constructor for this class:

```java
public Player(String name)
```
- Initialize the guessedLocationx and guessedLocationy to -1 in the constructor.
- Initialize the totalScore to zero in the constructor.

Implement the getter and setter methods for guessedLocationx, guessedLocationy variables, and getter methods for totalScore and name variables.

Define incrementTotalScore method:

```java
public void incrementTotalScore(int points)
```

- This method increases the totalScore by points amount.

# HotCold Class

Inside the hotcold package, you will create another class called HotCold.

## Instance variables:
```java
Player player1;
Player player2;
int xLocationToGuess;
int yLocationToGuess;
```

## Public Methods:

Define the constructor for this class:

```java
public HotCold(Player player1, Player player2, int xLocationToGuess, int yLocationToGuess)
```

Define the play method:

```java
public void play()
```

This method will get players' guessed location coordinates (x,y) and calculate the distances of the players' input with **xLocationToGuess** and **yLocationToGuess**.

Assume **locationToGuess** is the location given with both **xLocationToGuess** and **yLocationToGuess**, **distance1** will be player1's Euclidean distance to **locationToGuess**, and **distance2** will be player 2's Euclidean distance to **locationToGuess**.

**Note**: You can use Java’s **Math** class for necessary mathematical functions for finding the Euclidean distance.

You must print **distance1** and **distance2** as follows:

"Name of player 1"+ distance is +“distance1”+”.”
"Name of player 2"+ distance is +“distance2”+”.”

**Important**: Your output should display 3 digits after the precision. Example: 2.964, 187.368

The scoring criteria for players are as follows:

- If distance1 is smaller than distance2, player 1 is rewarded with 1 point.

- If distance2 is smaller than distance1, player 2 is rewarded with 1 point.

In both of the cases above, you must print the winning player's name in an understandable manner. As an example:

```java
"Name of a player" + " won."
```

If distance1 equals distance2, both players are rewarded with 3 points. You must print:

```java
"Name of player 1"+ " and "+ "Name of player 2"+ " were the same distance to the location!"
```
Here is an example:

Note: x* in the figure is xLocationToGuess and y* in the figure is yLocationToGuess.

![](https://github.com/Comp132Classroom/Spring2023-Lab1/blob/main/Example_round.jpg)

Define the whoWon method:

```java
public void whoWon()
```

This method will compare the points of both players and print out the location coordinate to guess, and the winner with how much points the winner earned, which must look like:
```java
"Location to guess was: x: "+ xLocationToGuess+ ", y: " +yLocationToGuess+ "."
"Name of the winning player" + " has won Hot and Cold with a total " + " total score of the winning player" + " points.”
```

However; if both players got the same total score, the output must look like this:

```java
"Hot and Cold between " + "Name of player 1" + " and " + "Name of player 2" + " resulted in a tie with both scoring " + "Score of a player" + " points.”
```

# Main Class

In the Main class under package main, you should implement the main method with the following algorithm:

- Get 2 player names from the terminal input and create 2 Player objects.

- Generate random x and y coordinates for the HotCold object.

**Important**: You should use the getRandomNumber() method to get a number between 0 and 255 (both inclusive), which has already been given to you in the Main class.

- Create a HotCold object with the created Player objects and the previously generated x and y coordinates.

- Play 3 rounds of Hot and Cold by getting guessed locations from each of the players. For both players, integers for x and y locations must be between 0 and 255 (both inclusive). You must print the following sentence before getting an integer input from each of the players.

```java
"Name of a player" + " enter a number between 0 and 255 for the x location (both inclusive)."

"Name of a player" + " enter a number between 0 and 255 for the y location (both inclusive)."
```

If a player puts a number outside of the range 0 and 255, you must print the following sentence and get another input from the player.
```java
"Wrong input is given. Try Again."
```

**Note**: Do not forget to set a player's guessed number before playing a round of  Hot and Cold.

- If any of the players guessed the generated location correctly or 3 rounds have finished, you must stop the game session and print the result of the Hot and Cold session.


# Sample Run

```console

Player 1 Name:
Dogan

Player 2 Name:
Abdulrezzak

Dogan enter a number between 0 and 255 for the x location (both inclusive).
24

Dogan enter a number between 0 and 255 for the y location (both inclusive).
100

Abdulrezzak enter a number between 0 and 255 for the x location (both inclusive).
125

Abdulrezzak enter a number between 0 and 255 for the y location (both inclusive).
200

Dogan's distance is 13.0.
Abdulrezzak's distance is 3.464.
Abdulrezzak won.

Dogan enter a number between 0 and 255 for the x location (both inclusive).
200

Dogan enter a number between 0 and 255 for the y location (both inclusive).
210

Abdulrezzak enter a number between 0 and 255 for the x location (both inclusive).
255

Abdulrezzak enter a number between 0 and 255 for the y location (both inclusive).
200

Dogan's distance is 10.344.
Abdulrezzak's distance is 10.862.
Dogan won.

Dogan enter a number between 0 and 255 for the x location (both inclusive).
180

Dogan enter a number between 0 and 255 for the y location (both inclusive).
180

Abdulrezzak enter a number between 0 and 255 for the x location (both inclusive).
210

Abdulrezzak enter a number between 0 and 255 for the y location (both inclusive).
43

Dogan's distance is 9.433.
Abdulrezzak's distance is 8.602.
Abdulrezzak won.

Location to guess was: x:211, y:114.
Abdulrezzak has won the Hot and Cold with 2 points.
```

