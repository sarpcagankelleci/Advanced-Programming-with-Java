package exception;

public class InvalidBookException extends Exception {
	public InvalidBookException(String string) {
		super("InvalidBookException: Book is invalid because " + string);
	}
}
