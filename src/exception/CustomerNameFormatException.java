package exception;

public class CustomerNameFormatException extends CustomerException{

    public CustomerNameFormatException() {

    }

    public CustomerNameFormatException(String message) {
        super(message);
    }
}
