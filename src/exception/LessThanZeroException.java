package exception;

public class LessThanZeroException extends CustomerException {
    public LessThanZeroException() {

    }

    public LessThanZeroException(String message) {
        super(message);
    }
}
