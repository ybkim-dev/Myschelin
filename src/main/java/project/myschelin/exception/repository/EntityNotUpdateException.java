package project.myschelin.exception.repository;

public class EntityNotUpdateException extends RepositoryException {
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
