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

# Spring2023-Lab2
## COMP 132: Advanced Programming

### Spring 2023: Lab-2 - KU-Mates: Finding a Housemate

In this programming lab, you are given a scenario and a Java project. You are asked to write multiple class declarations, implement the methods described and test the correctness of your implementation by using the test code given in the template project. Please note that we may test your codes with other test cases as well.

**Scenario:** A real estate agency manages shared houses around Koc University where multiple persons can share the same house. Each house has a capacity (i.e. number of persons that can live in that house). The landlord of each house imposes an income restriction. Every person has a monthly income and is looking for a shared house. In this pre-lab, you are asked to design and implement a program, namely KU-Mates, to solve the following tasks.

In the given Java project template, create a package named housing, then inside this package, define the following classes. For each class, you should implement the required methods as described below. You may also add other methods if needed. 

### Person Class

Every object of the Person Class has a name of type String and a monthly income of type double.
Define the necessary instance variables of the class.

Write two constructors,
The first one is a two-argument signature constructor that takes the name and monthly income as input. 
And the second constructor only takes monthly income as input and assigns the name of the object as “Anonymous” by default.

The **income update of a person** can be done as a net or gross increase, as follows:

1. **Net Increase:** Net update amount can be declared, so to handle this, implement a method named **```updateIncome```** in this class. This method should have one parameter to take an amount of type double as input and update the person's current income accordingly.
- For instance, if the monthly income of a person is $5000, and the given amount is $375.45, then the updated income becomes  [5000 + 375.45 = $5375.45]

2. **Gross Increase:** The total amount and percentage of non-tax part that will be added to the current income can be declared, so to handle this, implement another method named as **```updateIncome```** in this class. This method should have two parameters:  a total amount of type double and a percentage of type double, then update the person's current income accordingly.
- For instance, if the monthly income of a person is $5000, the given total amount is $625.90 and the percentage value is 60 then the updated income becomes [5000 + (625.90 * 0.60) = $5375.54]

**Hint:** If you confuse methods with the same name in the same class, you should review the concept of Method Overloading. 

### SharedHouse Class

Each object of the **```SharedHouse```** class has an address of type String, a fixed-size array of persons who live in the house, and a minimum required monthly income of type double.
- Define the necessary instance variables of the class.
- Write a constructor with a three-argument signature that takes the address, house capacity, and minimum required monthly income as inputs. The constructor should initialize the corresponding variables with the given arguments. Additionally, an array object of persons should be created with the size of the array being set as the capacity of the house.

To evaluate the eligibility of a person for the house, write a method called **```isEligible```**. This method should take the person to be evaluated as the argument, then the method checks the monthly income of the person and if it is equal to or higher than the required level for that shared house, it **returns true**. Else it **returns false**. 

In the scenario where the evaluated person is eligible for the house, you'll need a method to add the person to the array of persons who live in the house. To accomplish this, you should write a method named **```addPerson```**, which takes the person to be added as an argument. If there is enough space in the array of persons, this method adds the person to the array and **returns true**. Else it prints **```"Shared house is full''```** and **returns false**.

### Agency Class

Each object of **```Agency```** Class has an agency name of type String, and a fixed-size array of shared houses (of type SharedHouse) with size 3. 
- Define the necessary instance variables of the class.
- Write a constructor with a one-argument signature that takes the agency name as input.

In this class, implement **```addSharedHouse(String houseAddress, int capacity, double minIncome)```** method which adds a shared house with the given address, capacity, and minimum required monthly income, then adds it to the first available slot in the shared houses array. 

In this class, implement **```findHouse(Person person)```** method. This method finds a shared house for the given person in the agency’s shared houses array by calling the **```isEligible```** method of each house with the person parameter. If the person is eligible for a shared house, it adds the person to the house by calling the **```addPerson```** method of the house. A person can be added to at most one house.

Implement **```toString()```** method which returns a String representation of the **```Agency```** class containing the name of the agency, the names of the shared houses, minimum required monthly incomes for shared houses, and the list of the accepted persons for each shared house. Please ensure that you provide the following string format:

--------------------------------------------------------------------------------------------------------
```
Agency Name: <agency name>

SharedHouse Address: <shared house address>
SharedHouse Capacity: <capacity of the house>
Minimum Income: <monthly income>
Persons:
<Person name> <Person income>
…
<Person name> <Person income>
…
```
--------------------------------------------------------------------------------------------------------

### TestAgency Class

**```TestAgency```** class is provided for you with some available test code in it. This class is designed to test the functionality of the **```Person```**, **```Agency```**, and **```SharedHouse```** classes. In the given main method, several Person objects are instantiated and their incomes are updated using the **```updateIncome```** method. Then, two Agency objects are instantiated and several SharedHouse objects are added to each agency using the addSharedHouse method. Next, the findHouse method is called for each Agency object with different Person objects as arguments. This method finds a suitable SharedHouse for the person based on their income and capacity requirements. Finally, the details of both Agency objects are printed using the Agency class **```toString```** method.

**Implement** a **static** method named **```listAvailability```** in the **```TestAgency Class```**. This method takes an Agency object and an integer availability as the parameters. It iterates over all the shared houses in the agency's houses array, and for each house, it calculates the current availability by subtracting the number of persons currently assigned to the house from its capacity. If the current availability is greater than or equal to the requested availability, the house address is printed on the console. If no matching houses are found, a message indicating this is printed on the console.  
After implementing this method, **call** the **```listAvailability```** method two times with 2 and 8 for agency1 at the end of the main method. See the expected sample output below.


### Sample Output

--------------------------------------------------------------------------------------------------------
```
Shared house is full

Shared house is full

Shared house is full

Shared house is full

Shared house is full


Agency Name: Brick Lane Realty

SharedHouse Address: Steintorwall 10
SharedHouse Capacity: 2
Minimum Income: 15000.0
persons:
Carey 36000.0
Dennis 15000.0

SharedHouse Address: Schlosspassage 21
SharedHouse Capacity: 4
Minimum Income: 20000.0
persons:
Phoebe 25000.0
Karen 21000.0
Doe 22000.0

SharedHouse Address: Dompl. 5
SharedHouse Capacity: 3
Minimum Income: 25000.0
persons:



Agency Name: Citadel Partners Realty

SharedHouse Address: Am Theater 1
SharedHouse Capacity: 2
Minimum Income: 16000.0
persons:
Cate 20000.0
Andrew 55400.0

SharedHouse Address: Steinweg 27
SharedHouse Capacity: 3
Minimum Income: 12000.0
persons:
Mary 12000.0
Anonymous 70000.0
Anonymous 120000.0


House address with available capacity 2 : Dompl. 5
No matching houses found with available capacity 8
```
--------------------------------------------------------------------------------------------------------



### Appendix

This part includes **additional** conceptual information for your reference. Flowchart is an excellent tool for breaking down complex tasks into smaller, more manageable steps, making it easier to visualize and organize your code. To provide an example, we have included the flowchart for the prelab exercise below. This flowchart illustrates the steps involved in the process and the decision points where the program needs to take different actions. By using this flowchart as a reference, you can better understand the problem you are trying to solve and create a clear plan of action for your code. In addition to this example, we encourage you to consider using flowcharts in your future software development projects.

![Blank diagram - Page 1 (1)](https://user-images.githubusercontent.com/61591938/225364759-86329189-4bb4-41df-876b-0e64f56efc61.png)

In addition to flowcharts, there are several other alternatives that you can use to visualize code and program logic. One popular alternative is pseudocode, which is a high-level description of the steps involved in a program written in plain language. Pseudocode can be especially useful in the early stages of development, allowing you to sketch out the structure and functionality of your program without getting bogged down in syntax. Another option is UML diagrams, which are commonly used in software engineering to model complex systems and processes. UML diagrams can be used to represent the relationships between different components of a system, including classes, objects, and modules, and can be especially useful in object-oriented programming. Finally, some developers prefer to use mind maps or concept maps to visualize their code. These types of diagrams can be helpful for brainstorming and organizing ideas, and can be especially useful when working on larger, more complex projects.
