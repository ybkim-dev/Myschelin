package project.myschelin.exception.database;

public class EntityNotDeleteException extends RepositoryException {
    public EntityNotDeleteException() {
    }

    public EntityNotDeleteException(String message) {
        super(message);
    }

    public EntityNotDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotDeleteException(Throwable cause) {
        super(cause);
    }

    public EntityNotDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
