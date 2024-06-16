/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Sarp Çağan Kelleci, 79482>
********************************************************************************/

import housing.Person;
import housing.SharedHouse;

import java.util.Scanner;

import housing.Agency;

public class TestAgency {

	public static void main(String[] args) {
		
		//System.out.println("Total Person Count: " + Person.getCount());
		
		// define Persons
		Person m1 = new Person("Carey", 30000);
		Person m2 = new Person("Mary", 12000);
		Person m3 = new Person("Dennis", 15000);
		Person m4 = new Person("Cate", 20000);
		Person m5 = new Person("Phoebe", 25000);
		Person m6 = new Person("Andrew", 50000);
		Person m7 = new Person("John", 10000);
		Person m8 = new Person("Karen", 21000);
		Person m9 = new Person("Doe", 22000);
		
		// define Anonymous Persons
		Person m10 = new Person(70000);
		Person m11 = new Person(120000);

		// update income for some Persons
		m1.updateIncome(6000);
		m6.updateIncome(9000, 60);

		// define agencies
		Agency agency1 = new Agency("Brick Lane Realty");
		Agency agency2 = new Agency("Citadel Partners Realty");

		// add houses to agencies
		agency1.addSharedHouse("Steintorwall 10", 2, 15000);
		agency1.addSharedHouse("Schlosspassage 21", 4, 20000);
		agency1.addSharedHouse("Dompl. 5", 3, 25000);

		agency2.addSharedHouse("Am Theater 1", 2, 16000);
		agency2.addSharedHouse("Steinweg 27", 3, 12000);

		// find house to given Persons
		agency1.findHouse(m1);
		agency1.findHouse(m3);
		agency1.findHouse(m5);
		agency1.findHouse(m8);
		agency1.findHouse(m9);

		agency2.findHouse(m2);
		agency2.findHouse(m4);
		agency2.findHouse(m6);
		agency2.findHouse(m7);


		agency2.findHouse(m10);
		agency2.findHouse(m11);

		// print agency info
		System.out.println(agency1);
		System.out.println(agency2);

        TestAgency.listAvailability(agency1, 2);
        TestAgency.listAvailability(agency1, 8);
        
        //System.out.println("Total Person Count: " + Person.getCount());
        
        // test 
        //System.out.println("Testing with agency1:");
        //TestAgency.checkPerson(agency1, "Mary");

        //test 
        //System.out.println("Testing with agency2:");
        //TestAgency.checkPerson(agency2, "Mary");
        
        
	}
	public static void listAvailability(Agency agency, int availability) {
		boolean found = false;
		for (int i = 0; i< agency.getHousesSum(); i++) {
			int capacity = agency.getAgencyHouses()[i].getWhoLiveIn().length - agency.getAgencyHouses()[i].getPeopleSum();
			if (capacity >= availability) {
				System.out.println("House address with available capacity " + availability + " : " + agency.getAgencyHouses()[i].getAddress());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No matching houses found with available capacity "+ availability);
		}
	}
	
	/*public static void checkPerson(Agency agency, String name) {
        boolean found = false;
        for (SharedHouse houseInfo : agency.getAgencyHouses()) {
            for (int i = 0; i < houseInfo.getPeopleSum(); i++) {
                Person person = houseInfo.getWhoLiveIn()[i];
                if (person.getName().equals(name) && person != null) {
                    found = true;
                    System.out.println(name + " is found in given agency!");
                    break;
                }
            }
            if (found == true) {
                break;
            }
        }
        if (found == false) {
            System.out.println(name + " is not found in given agency!");
        }
    }
	*/
    
}
	

	

