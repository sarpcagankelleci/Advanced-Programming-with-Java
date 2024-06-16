package housing;

public class Agency {
	
	private String agencyName;
	private SharedHouse[] agencyArray;
	private int housesSum = 0;
	
	public String getAgencyName() {
		return agencyName;
	}

	public SharedHouse[] getAgencyHouses() {
		return agencyArray;
	}

	public int getHousesSum() {
		return housesSum;
	}

	public Agency(String name) {

		this.agencyName = name;
		SharedHouse[] agencyArray = new SharedHouse[3];
		this.agencyArray = agencyArray;
	}
	
	public boolean addSharedHouse(String houseAddress, int capacity, double minIncome) {
		
		SharedHouse agencyHouses = new SharedHouse(houseAddress, capacity, minIncome);
		if (housesSum != agencyArray.length) {
			agencyArray[housesSum++] = agencyHouses;
			return true;
		}
		else {
			System.out.println("No capacity on sharedHouses array.");
			return false;
		}
	}
	
	public void findHouse(Person person) {
		for (int i= 0; i<housesSum; i++) {
			if (agencyArray[i].isEligible(person)) {
				if (agencyArray[i].addPerson(person)) {
					break;
				}
			}
		}
	}

	public String toString() {
		
		String message = "Agency Name: " + this.agencyName + "\n\n";
		for (int i = 0; i < housesSum; i++) {
			message +=  "SharedHouse Address: " + agencyArray[i].getAddress() + "\n";
			message += 	"SharedHouse Capacity: " + agencyArray[i].getWhoLiveIn().length + "\n"; 
			message += 	"Minimum Income: " + agencyArray[i].getMinimumMonthlyIncome() + "\n";
			message += 	"Persons:" + "\n";
			for (int j= 0; j < agencyArray[i].getPeopleSum(); j++) {
				message += agencyArray[i].getWhoLiveIn()[j].getName() + " " + agencyArray[i].getWhoLiveIn()[j].getMonthlyIncome()+ "\n";
			}
			message += "\n\n";
		}
		return message;
	}
	

}