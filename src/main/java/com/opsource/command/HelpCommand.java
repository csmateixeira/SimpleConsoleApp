package com.opsource.command;

import com.opsource.pojo.Commands;

/**
 * Created by Nixka on 11/10/2014.
 */
public class HelpCommand implements Command {

    @Override
    public void run() {
        System.out.println(Commands.HELP.getDescription());
        System.out.println(Commands.COUNT_SERVERS.getDescription());
        System.out.println(Commands.ADD_SERVER.getDescription());
        System.out.println(Commands.EDIT_SERVER.getDescription());
        System.out.println(Commands.DELETE_SERVER.getDescription());
        System.out.println(Commands.LIST_SERVERS.getDescription());
    }
}
