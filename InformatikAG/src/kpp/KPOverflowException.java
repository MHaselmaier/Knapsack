package kpp;

public class KPOverflowException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KPOverflowException() {
		super("KPOverflow! Maximum capacity exceeded.");
	}
	
}
