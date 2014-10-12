package com.opsource.controller.command;

import com.opsource.model.Server;
import com.opsource.model.Commands;
import org.springframework.stereotype.Component;

@Component
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

    @Override
    public void run(Server args) {

    }


}
