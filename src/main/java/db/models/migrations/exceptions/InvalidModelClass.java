package db.models.migrations.exceptions;

public class InvalidModelClass extends RuntimeException {
    public InvalidModelClass() {
    }

    public InvalidModelClass(String message) {
        super(message);
    }

    public InvalidModelClass(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidModelClass(Throwable cause) {
        super(cause);
    }

    public InvalidModelClass(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
