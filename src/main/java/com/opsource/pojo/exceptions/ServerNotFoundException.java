package com.opsource.pojo.exceptions;

public class ServerNotFoundException extends Exception {

    public ServerNotFoundException(String message){
        super(message);
    }

    public ServerNotFoundException(){
        super("Server ID  not found");

    }
}
