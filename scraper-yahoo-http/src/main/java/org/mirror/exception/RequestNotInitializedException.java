package org.mirror.exception;

public class RequestNotInitializedException extends RuntimeException {

    public RequestNotInitializedException() {
        super();
    }

    public RequestNotInitializedException(String message) {
        super(message);
    }

    public RequestNotInitializedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestNotInitializedException(Throwable cause) {
        super(cause);
    }
}