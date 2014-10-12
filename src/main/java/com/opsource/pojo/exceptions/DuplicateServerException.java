package com.opsource.pojo.exceptions;

public class DuplicateServerException extends Exception {

    public DuplicateServerException() {
        super("duplicate server found");
    }

    public DuplicateServerException(String message) {
        super(message);
    }
}
