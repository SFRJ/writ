package com.writ.domain.core.errors;

public class TermNotFoundException extends RuntimeException {
    public TermNotFoundException(String message) {
        super(message);
    }
}
