package exception;

public class CustomerIDFormatException extends CustomerException {
    public CustomerIDFormatException() {

    }

    public CustomerIDFormatException(String message) {
        super(message);
    }
}
