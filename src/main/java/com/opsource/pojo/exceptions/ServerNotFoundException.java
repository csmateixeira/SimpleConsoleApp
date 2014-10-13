package com.opsource.pojo.exceptions;

/**
 * @author Carla Teixeira
 * Exception for non-existing servers
 */
public class ServerNotFoundException extends Exception {

    public ServerNotFoundException(String message){
        super(message);
    }

    public ServerNotFoundException(){
        super("server not found");

    }
}
