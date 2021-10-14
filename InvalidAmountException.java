/**
 * 
 * This exception will be thrown when the amount is less than or equal to 0 
 * when the credit and debit operations are performed on an Account.
 * 
 * @author N. D. V. Siva Sankar.
 * @author <Student Name>
 * 
 * @version 1.0
 */

public class InvalidAmountException extends Exception {
	/**
	 * A serial version uid for this class used by JVM.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A new object has to be created everytime when the client wants to throw
     * an Exception of this type.
	 * @param message Constructs a new exception with the specified detail message.
	 */
	public InvalidAmountException(String message) {
		super(message);
	}
}