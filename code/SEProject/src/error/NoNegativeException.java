package error;
/**
 * When user insets a negative input this class used to handle it.
 * @author mwi67, amo174
 *
 */
public class NoNegativeException extends IllegalStateException{
	public NoNegativeException() {};
	
	public NoNegativeException(String message) {
	super(message);
	}

}
