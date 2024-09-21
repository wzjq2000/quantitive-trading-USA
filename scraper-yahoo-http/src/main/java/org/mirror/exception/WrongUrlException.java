package org.mirror.exception;

public class WrongUrlException extends RuntimeException {

    public WrongUrlException() {
        super();
    }

    public WrongUrlException(String message) {
        super(message);
    }

    public WrongUrlException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongUrlException(Throwable cause) {
        super(cause);
    }
}
