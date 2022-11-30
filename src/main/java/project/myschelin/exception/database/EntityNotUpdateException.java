package project.myschelin.exception.database;

public class EntityNotUpdateException extends DatabaseException {
    public EntityNotUpdateException() {
    }

    public EntityNotUpdateException(String message) {
        super(message);
    }

    public EntityNotUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotUpdateException(Throwable cause) {
        super(cause);
    }

    public EntityNotUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
