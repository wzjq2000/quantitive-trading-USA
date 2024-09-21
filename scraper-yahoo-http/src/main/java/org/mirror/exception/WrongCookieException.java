package org.mirror.exception;

public class WrongCookieException extends RuntimeException {

    public WrongCookieException() {
        super();
    }

    public WrongCookieException(String message) {
        super(message);
    }

    public WrongCookieException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongCookieException(Throwable cause) {
        super(cause);
    }
}