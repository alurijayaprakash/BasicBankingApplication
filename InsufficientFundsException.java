/**
 * 
 * This exception will be thrown when the amount is not sufficient to 
 * withdraw or debit from a particular Account.
 * 
 * @author N. D. V. Siva Sankar.
 * @author <Student Name>
 * 
 * @version 1.0
 */

public class InsufficientFundsException extends Exception {
	/**
	 * A serial version uid for this class used by JVM.
	 */
	private static final long serialVersionUID = 1L;


    /**
     * A new object has to be created everytime when the client wants to throw
     * an Exception of this type.
     * 
     * @param message Constructs a new exception with the specified detail message.
     */
	public InsufficientFundsException(String message) {
		super(message);
	}
}