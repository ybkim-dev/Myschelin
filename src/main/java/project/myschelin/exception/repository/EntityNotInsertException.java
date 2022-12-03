package project.myschelin.exception.repository;

public class EntityNotInsertException extends RepositoryException {
    public EntityNotInsertException() {
    }

    public EntityNotInsertException(String message) {
        super(message);
    }

    public EntityNotInsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotInsertException(Throwable cause) {
        super(cause);
    }

    public EntityNotInsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
