[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-8d59dc4de5201274e310e4c54b9627a8934c3b88527886e3b421487c677d23eb.svg)](https://classroom.github.com/a/LYU_5ZWG)
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

## Spring 2023: Lab-4 Prelab: StreamingService Notifies

In this lab, you will be practicing with Inheritance related concepts, and ArrayList data structure. Inheritance is one of the key aspects that make Object-Oriented Programming (OOP) possible and incentivizes code reuse by modeling an “is-a” relation between an existing class (Superclass) and derived classes (Subclasses).

To practice with these concepts, you are going to implement an imaginary Netflix-like streaming service application that notifies its users every time a new movie or tv series that matches the user’s liked genres.

There are three packages which are:
- media
- devices
- streaming

There are going to be 10 classes from which two of them, namely Enum Class Genre and Main Class are provided to you. The basic enum type, that is provided to you with the template project, defines a set of constants represented as unique identifiers. In other words, an enum type is a special data type that enables for a variable to be a set of predefined constants. Similar to usual classes, all enum types can be used as reference types. Examine the template project’s Genre and Main classes to observe how these constants are used. On the other hand, the Main class that is shared with you will serve as a test code snippet, where each line would check a different functionality of the classes that you are about to implement.

The remaining parts are summarized as follows:

- Under media package:
    - ``Genre`` class is an “enum” class which will be provided to you.
    - ``Media`` class is a superclass that reflects what's common to all movies and tv series.
    - ``Movie`` class is a subclass of Media class
    - ``Series`` class is a subclass  of Media class

- Under devices package:
    - ``Device`` class is a superclass for all streaming devices
    - ``CellPhone`` is a subclass of Device class
    - ``PersonalComputer`` is a subclass of Device class

- Under streaming package:
    - ``User`` class specifies the common internal data of a user.
    - ``StreamingService`` class contains all users, media, devices and most functionalities
    - ``Main`` class is given to you. You shouldn’t change anything in this class for prelab.


NOTE: For each class implementation, you need to decide which access modifiers should be used for instance variables (e.g., private, protected, or public). In some of the classes, you need to decide on which data types and names you should use for those variables as well.

# Media class 
Every Media has the following fields (you need to decide on which fields are private, protected, or public): 
- Name of the Media ``(String)``
- Year that the Media is published ``(int)``
- Genre of the Media ``(Genre)``

In addition, Media class has the following methods:

- Implement a constructor for the Media class.
- Implement getter/setter methods if needed.
- Implement a ``toString`` method that displays Media’s instance variables. You can examine the sample output located at the end of this document in order to get a grasp of Media’s toString method.
- Implement a ``String generateNotification()`` method that will convey the news that the Media item is now available on the streaming service. This method should only produce a String that says a new Media item with its corresponding Genre field is ready to watch. You can examine the sample output located at the end of this document in order to get a grasp of Media’s toString method.

# Movie class
Movie is a subclass of the Media class and each Movie instance has the following fields (you need to decide on which fields are private, protected, or public): 
- Name of the Director ``(String)``
- Duration in hours ``(int)``
- Duration in minutes ``(int)``

And following methods:

- Implement a constructor for the Movie class. 
- Implement a ``toString`` method that overrides its superclass’ and adds Movie’s instance variables to the output text. You can examine the sample output located at the end of this document in order to get a grasp of Movie’s toString method. *HINT*: You might call Movie’s superclass’ toString method while doing so.
- Implement a ``String generateNotification()`` method that overrides its superclass’ method with the same name and adds this Movie instance’s toString() text on top of it. You can examine the sample output located at the end of this document in order to get a grasp of Movie’s generateNotification method. *HINT*: You might call Movie’s  superclass’ generateNotification method while doing so.

# Series class
Series is a subclass of the Media class and each Series instance has the following fields (you need to decide on which fields are private, protected, or public): 

- Name of the Network ``(String) ``
- Duration in seasons ``(int)``
- Duration in total episodes ``(int)``

Additionally, Series class has methods that are explained as below:

- Implement a constructor for the Series class. 
- Implement a ``toString`` method that displays instance variables of the Series class. You can examine the sample output located at the end of this document in order to get a grasp of the toString method. *HINT*: You might call Series’s superclass’s toString method while doing so.
- Implement a ``String generateNotification()`` method that overrides its superclass’ method with the same name and adds this Series instance’s toString() text on top of it. You can examine the sample output located at the end of this document in order to get a grasp of Series’ generateNotification method. *HINT*: You might call Movie’s  superclass’ generateNotification method while doing so.

# Device class 
Every Device has the following fields (you need to decide on which fields are private, protected, or public): 
- Each device has a unique id as a field. (*HINT*: you can use a static variable to keep track of each id to assign to the new device, id’s should start with 0.)
- Each device has a User that it belongs to. 

In addition, Device class has the following methods:

- Implement a constructor for the Device class. Constructor should only take a User class variable as an argument.  User class will be introduced in a couple of subsections. Upon the creation of a new Device instance with a specified User, Device class constructor should add this Device instance to User’s devices ArrayList, In addition, constructor should increase the unique id counter every time a new Device instance is created.
- Implement a ``String notifyOwner(Media m)`` method that notifies the User instance u of this device, with a scripted message that states a new Media item m is available on the Streaming Service. *HINT*: This method should produce a String that greets the User of this Device with their username and then call Media item m’s generateNotification() to produce the rest of the notification. You can examine the sample output located at the end of this document in order to get a grasp of the notifyOwner method. 

# CellPhone class
CellPhone is a subclass of the Device class. Each CellPhone has no fields but just a simple constructor that only calls its superclass’. 
Only other functionality that CellPhone class has is to override its superclass’s ``notifyOwner`` method in order to provide additional information about the notification that is sent. You can examine the sample output located at the end of this document in order to find out how CellPhone overrides the notifyOwner method.

# PersonalComputer class
PersonalComputer is a subclass of the Device class. Each PersonalComputer has no fields but just a simple constructor that only calls its superclass's. 
Only other functionality that the PersonalComputer class has is to override its superclass’s ``notifyOwner`` method in order to provide additional information about the notification that is sent. You can examine the sample output located at the end of this document in order to find out how PersonalComputer overrides the notifyOwner method.

# User class 
Every User has the following fields (you need to decide on which fields are private, protected, or public): 
- username of the User ``(String)``
- likedGenres of the User ``(ArrayList<Genre>)``
- devices of the User ``(ArrayList<Device>)``

 Additionally, User class has methods that are explained as below:
 
- Implement a constructor for the User class that only takes the username as an argument.
- Implement getter methods.
- Implement the following methods; ``likeGenre(Genre g)``, ``unlikeGenre(Genre g)``, ``removeDevice(Device d)``.

# StreamingService class 
StreamingService has the following fields (you need to decide on which fields are private, protected, or public): 
- media of the StreamingService ``(ArrayList<Media>)``
- users of the StreamingService ``(ArrayList<User>)``
 
 In addition, StreamingService class has the following methods:

- Implement a constructor for the StreamingService class that doesn't take any arguments.
- Implement ``addMedia(Media m)`` and ``addUser(User u)`` methods that add Media and User instances that are passed as input arguments to their respective ArrayLists. *NOTE*: Notice from sample output that both addMedia(Media m) and addUser(User u) methods first search for any duplicate names for the Media items and usernames for the User instances before making any additions to either ArrayLists. If a match is found for either m’s name or u’s username then they are simply not added to the ArrayLists and an appropriate error message is displayed.
- Implement ``notifyAllUsers()`` method that notifies all Users from all their Devices about the Media collection of the StreamingService according to User’s liked Genres. In order to implement such a method, it is needed to iterate through every *User u* enlisted to the StreamingService, store *u*’s *likedGenres* and *devices*, then iterate through every *Media* collection instance *m* to see whether *m*’s Genre matches any inside *u*’s *likedGenres*. If that is the case, notifyAllUsers() should finally sweep through u’s all devices, call their notifyOwner method and print the notification message accordingly.

## Sample output

```console

User added to the Streaming Service
User added to the Streaming Service
User added to the Streaming Service
User with the same username already exists. User cannot be added to StreamingService
Media added to the Streaming Service
Media added to the Streaming Service
Media added to the Streaming Service
Media with the same name already exists. Media cannot be added to StreamingService
Media added to the Streaming Service
Media added to the Streaming Service
Media added to the Streaming Service
Media added to the Streaming Service
Media added to the Streaming Service
--------------------------------------------------
Hey there canK,
A new SCIFI movie is added to our platform.
We thought you might like it!
--------------------------------------------------
Movie Information:
Name: Interstellar
Year: 2014
Genre: SCIFI
Director: Christopher Nolan
Duration: 2 hours and 49 minutes
--------------------------------------------------
Watch it now on your CellPhone device with the id:0
--------------------------------------------------
--------------------------------------------------
Hey there canK,
A new ROMANCE movie is added to our platform.
We thought you might like it!
--------------------------------------------------
Movie Information:
Name: The Notebook
Year: 2004
Genre: ROMANCE
Director: Nick Cassavetes
Duration: 2 hours and 3 minutes
--------------------------------------------------
Watch it now on your CellPhone device with the id:0
--------------------------------------------------
--------------------------------------------------
Hey there doganS,
A new COMEDY movie is added to our platform.
We thought you might like it!
--------------------------------------------------
Movie Information:
Name: Meet the Parents
Year: 2014
Genre: COMEDY
Director: Jay Roach
Duration: 1 hours and 48 minutes
--------------------------------------------------
Watch it now on your CellPhone device with the id:1
--------------------------------------------------
--------------------------------------------------
Hey there doganS,
A new COMEDY series is added to our platform.
We thought you might like it!
--------------------------------------------------
Series Information:
Name: Friends
Year: 1994
Genre: COMEDY
Network: NBC
Duration: 10 seasons and 234 episodes
--------------------------------------------------
Watch it now on your CellPhone device with the id:1
--------------------------------------------------
--------------------------------------------------
Hey there doganS,
A new ACTION series is added to our platform.
We thought you might like it!
--------------------------------------------------
Series Information:
Name: Reacher
Year: 2022
Genre: ACTION
Network: Amazon
Duration: 1 seasons and 8 episodes
--------------------------------------------------
Watch it now on your CellPhone device with the id:1
--------------------------------------------------
--------------------------------------------------
Hey there vahidehH,
A new FANTASY movie is added to our platform.
We thought you might like it!
--------------------------------------------------
Movie Information:
Name: Lord of the Rings: Two Towers
Year: 2002
Genre: FANTASY
Director: Peter Jackson
Duration: 2 hours and 59 minutes
--------------------------------------------------
Watch it now on your CellPhone device with the id:2
--------------------------------------------------
--------------------------------------------------
Hey there vahidehH,
A new FANTASY movie is added to our platform.
We thought you might like it!
--------------------------------------------------
Movie Information:
Name: Lord of the Rings: Two Towers
Year: 2002
Genre: FANTASY
Director: Peter Jackson
Duration: 2 hours and 59 minutes
--------------------------------------------------
Watch it now on your PersonalComputer device with the id: 5
--------------------------------------------------
--------------------------------------------------
Hey there vahidehH,
A new HORROR movie is added to our platform.
We thought you might like it!
--------------------------------------------------
Movie Information:
Name: Get Out
Year: 2017
Genre: HORROR
Director: Jordan Peele
Duration: 1 hours and 44 minutes
--------------------------------------------------
Watch it now on your CellPhone device with the id:2
--------------------------------------------------
--------------------------------------------------
Hey there vahidehH,
A new HORROR movie is added to our platform.
We thought you might like it!
--------------------------------------------------
Movie Information:
Name: Get Out
Year: 2017
Genre: HORROR
Director: Jordan Peele
Duration: 1 hours and 44 minutes
--------------------------------------------------
Watch it now on your PersonalComputer device with the id: 5
--------------------------------------------------

```
