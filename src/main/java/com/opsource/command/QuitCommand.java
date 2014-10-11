package com.opsource.command;

/**
 * Created by Nixka on 11/10/2014.
 */
public class QuitCommand implements Command {

    @Override
    public void run() {
        System.exit(0);
    }
}
