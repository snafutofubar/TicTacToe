package exceptions;

import model.Game;

public class gameOverException extends RuntimeException{
    public gameOverException() {
        super();
    }

    public gameOverException(String message) {
        super(message);
    }

    public gameOverException(String message, Throwable cause) {
        super(message, cause);
    }

    public gameOverException(Throwable cause) {
        super(cause);
    }

    protected gameOverException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
