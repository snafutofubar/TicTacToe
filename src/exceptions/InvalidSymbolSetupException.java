package exceptions;

public class InvalidSymbolSetupException extends RuntimeException{
    public InvalidSymbolSetupException() {
        super();
    }

    public InvalidSymbolSetupException(String message) {
        super(message);
    }

    public InvalidSymbolSetupException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSymbolSetupException(Throwable cause) {
        super(cause);
    }

    protected InvalidSymbolSetupException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
