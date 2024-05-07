package com.projectx.analytics.exceptions;

public class InvalidAccountIdException extends RuntimeException {
    public InvalidAccountIdException(String message) {
        super(message);
    }
}
