package com.writ.domain.core.errors;

public class AlreadyVotedOnThatTermException extends RuntimeException {

    public AlreadyVotedOnThatTermException(String message) {
        super(message);
    }
}