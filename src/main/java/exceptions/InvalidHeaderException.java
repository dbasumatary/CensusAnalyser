package exceptions;


public class InvalidHeaderException extends Exception {

    public InvalidHeaderException() {
        super();
    }

    public InvalidHeaderException(String message) {
        super(message);
    }

}