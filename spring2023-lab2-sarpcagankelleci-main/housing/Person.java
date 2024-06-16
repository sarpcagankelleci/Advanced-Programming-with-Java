package housing;

public class Person {

	private String name; // instance variable
	private double monthlyIncome; // instance variable
	//private static int countPeople = 0;
	
	//public static int getCount() {
    //   return countPeople;
	//}

	
	public Person(String name, double monthlyIncome) { // constructor 1
		this.name = name;
		this.monthlyIncome = monthlyIncome;
		//countPeople++;
	}

	public Person(double monthlyIncome) { // constructor 2
		this.monthlyIncome = monthlyIncome;
		this.name = "Anonymous";
		//countPeople++;
	}

	public String getName() { // getter for name
		return name;
	}
	
	public double getMonthlyIncome() { // getter for income
		return monthlyIncome;
	}

	public void updateIncome(double netIncrease) { // update income method 1: netIncrease
		this.monthlyIncome += netIncrease;		
	}
	
	public void updateIncome(double totalAmount, double percentage) { // update income method 2: grossIncrease
		this.monthlyIncome +=  totalAmount * (percentage / 100);	
	}
	
	public void setName(String name) { // setter for name
		this.name = name;
	}
	
	public void setMonthlyIncome(double monthlyIncome) { // setter for income
		if (monthlyIncome >= 0) {
		this.monthlyIncome = monthlyIncome;
		}
	}

}