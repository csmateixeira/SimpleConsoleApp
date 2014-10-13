package com.opsource.pojo.exceptions;

/**
 * @author Carla Teixeira
 * Exception for invalid server ids
 */
public class InvalidServerIdException extends Exception {

    public InvalidServerIdException() {
        super("Invalid Server ID entered");
    }

    public InvalidServerIdException(String message) {
        super(message);
    }
}
