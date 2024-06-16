package exception;

public class InvalidLoanException extends Exception{
	public InvalidLoanException(String string) {
		super("InvalidLoanException: Loan is invalid because " + string);
	}

}
