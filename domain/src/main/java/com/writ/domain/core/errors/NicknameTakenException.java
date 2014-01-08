package com.writ.domain.core.errors;

public class NicknameTakenException extends RuntimeException {

    public NicknameTakenException(String message) {
        super(message);
    }
}