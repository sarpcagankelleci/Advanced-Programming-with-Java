package exception;

public class NoSuchBookException extends Exception {
	public NoSuchBookException(String string) {
		super("NoSuchBookException: Loan aborted because " + string);
	}
	

}
