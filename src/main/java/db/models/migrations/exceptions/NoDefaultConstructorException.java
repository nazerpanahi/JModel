package db.models.migrations.exceptions;

public class NoDefaultConstructorException extends RuntimeException{
    public NoDefaultConstructorException() {
    }

    public NoDefaultConstructorException(String message) {
        super(message);
    }

    public NoDefaultConstructorException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDefaultConstructorException(Throwable cause) {
        super(cause);
    }

    public NoDefaultConstructorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
