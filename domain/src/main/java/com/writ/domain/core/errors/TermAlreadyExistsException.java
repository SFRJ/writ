package com.writ.domain.core.errors;

public class TermAlreadyExistsException extends RuntimeException {

    public TermAlreadyExistsException(String message) {
        super(message);
    }
}
