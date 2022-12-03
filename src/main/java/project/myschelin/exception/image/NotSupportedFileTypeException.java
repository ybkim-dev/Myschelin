package project.myschelin.exception.image;

public class NotSupportedFileTypeException extends FileException {
    public NotSupportedFileTypeException() {
    }

    public NotSupportedFileTypeException(String message) {
        super(message);
    }

    public NotSupportedFileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportedFileTypeException(Throwable cause) {
        super(cause);
    }

    public NotSupportedFileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
