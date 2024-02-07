package exceptions;

public class PasswordMismatchException extends Exception{

	public PasswordMismatchException() {
		super();
		
	}

	public PasswordMismatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public PasswordMismatchException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PasswordMismatchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PasswordMismatchException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}