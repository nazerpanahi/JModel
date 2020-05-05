package db.models.migrations.exceptions;

public class InvalidModelFieldTypeException extends RuntimeException{
    public InvalidModelFieldTypeException() {
    }

    public InvalidModelFieldTypeException(String message) {
        super(message);
    }

    public InvalidModelFieldTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidModelFieldTypeException(Throwable cause) {
        super(cause);
    }

    public InvalidModelFieldTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
