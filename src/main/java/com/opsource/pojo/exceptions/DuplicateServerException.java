package com.opsource.pojo.exceptions;

/**
 * @author Carla Teixeira
 * Exception for duplicate servers
 */
public class DuplicateServerException extends Exception {

    public DuplicateServerException() {
        super("duplicate server found");
    }

    public DuplicateServerException(String message) {
        super(message);
    }
}
