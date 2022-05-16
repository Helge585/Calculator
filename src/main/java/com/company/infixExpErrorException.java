package com.company;

public class infixExpErrorException extends Exception {
    public infixExpErrorException() {
    }

    public infixExpErrorException(String message) {
        super(message);
    }

    public infixExpErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public infixExpErrorException(Throwable cause) {
        super(cause);
    }
}
