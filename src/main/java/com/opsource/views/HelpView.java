package com.opsource.views;

import com.opsource.model.Commands;
import com.opsource.model.Status;
import org.springframework.stereotype.Component;

@Component
public class HelpView implements View{

    @Override
    public void render(Status status) {
        System.out.println(Commands.HELP.getDescription());
        System.out.println(Commands.COUNT_SERVERS.getDescription());
        System.out.println(Commands.ADD_SERVER.getDescription());
        System.out.println(Commands.EDIT_SERVER.getDescription());
        System.out.println(Commands.DELETE_SERVER.getDescription());
        System.out.println(Commands.LIST_SERVERS.getDescription());
    }
}
