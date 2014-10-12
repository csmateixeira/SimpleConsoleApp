package com.opsource.views;

import com.opsource.model.Commands;
import com.opsource.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ViewFactory {

    @Autowired
    HelpView helpView;

    @Autowired
    AddServerView addServerView;

    @Autowired
    CountServersView countServersView;

    @Autowired
    DeleteServerView deleteServerView;

    @Autowired
    EditServerView editServerView;

    @Autowired
    ListServersView listServersView;

    @Autowired
    InvalidCommandView invalidCommandView;

    public void render(Commands commands, Status status){

        switch (commands) {
            case HELP: helpView.render(status); break;
            case ADD_SERVER: addServerView.render(status); break;
            case COUNT_SERVERS: countServersView.render(status); break;
            case DELETE_SERVER: deleteServerView.render(status); break;
            case EDIT_SERVER: editServerView.render(status); break;
            case LIST_SERVERS: listServersView.render(status); break;
            default: invalidCommandView.render(status); break;
        }

    }
}
