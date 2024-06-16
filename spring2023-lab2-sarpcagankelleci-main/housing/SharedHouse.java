package housing;

public class SharedHouse {

	private String address;
	private Person[] whoLiveIn;
	private double minimumMonthlyIncome;
	//private int capacity;
	private int peopleSum = 0;
	
	
	public SharedHouse(String address, int capacity, double minimumMonthlyIncome) {
		
		this.address = address;
		this.minimumMonthlyIncome = minimumMonthlyIncome;
		//this.capacity = capacity;
		Person[] whoLiveIn = new Person[capacity];
		this.whoLiveIn = whoLiveIn;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getPeopleSum() {
		return peopleSum;
	}

	public Person[] getWhoLiveIn() { //
		return whoLiveIn;
	}

	public double getMinimumMonthlyIncome() {
		return minimumMonthlyIncome;
	}

	public boolean isEligible(Person person) {
		if (person.getMonthlyIncome() >= this.minimumMonthlyIncome) {
			return true;
		}
			return false;
	}
	
	public boolean addPerson(Person person) {
		if(isEligible(person) && peopleSum < whoLiveIn.length) {
			whoLiveIn[peopleSum++] = person;
			return true;	
		}
		else {
			System.out.println("Shared house is full" + "\n\n");
		}
		return false;
	}
		
	
}