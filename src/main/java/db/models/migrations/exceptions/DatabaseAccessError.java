package db.models.migrations.exceptions;

public class DatabaseAccessError extends RuntimeException {
    public DatabaseAccessError() {
    }

    public DatabaseAccessError(String message) {
        super(message);
    }

    public DatabaseAccessError(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseAccessError(Throwable cause) {
        super(cause);
    }

    public DatabaseAccessError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
