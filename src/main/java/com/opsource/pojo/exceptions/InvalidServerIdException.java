package com.opsource.pojo.exceptions;

public class InvalidServerIdException extends Exception {

    public InvalidServerIdException() {
        super("Invalid Server ID entered");
    }

    public InvalidServerIdException(String message) {
        super(message);
    }
}
