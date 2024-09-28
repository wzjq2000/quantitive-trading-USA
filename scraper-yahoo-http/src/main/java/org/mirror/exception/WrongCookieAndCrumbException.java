package org.mirror.exception;

public class WrongCookieAndCrumbException extends RuntimeException {

    public WrongCookieAndCrumbException() {
        super();
    }

    public WrongCookieAndCrumbException(String message) {
        super(message);
    }

    public WrongCookieAndCrumbException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongCookieAndCrumbException(Throwable cause) {
        super(cause);
    }
}