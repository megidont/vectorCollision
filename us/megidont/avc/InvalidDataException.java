package us.megidont.avc;

/**
* InvalidDataException is the RuntimeException thrown when a constructor in AVC gets invalid data.
*
* @author Megidon't
* @version 3.0
*/
public class InvalidDataException extends RuntimeException{

	/**
	* Constructs an <code>InvalidDataException</code> with a message.
	*
	* @param errorMessage	The message associated with the error.
	*/
	InvalidDataException(String errorMessage){

		super(errorMessage);

	}

}