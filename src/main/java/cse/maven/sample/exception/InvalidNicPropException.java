package cse.maven.sample.exception;

public class InvalidNicPropException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNicPropException() {
		super("Invalid NIC is entered.");
	}
}
