package com.opsource.command;

import com.opsource.dao.ServerDao;
import com.opsource.dao.entities.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditServerCommand implements Command {

    @Autowired
    ServerDao serverDao;

    @Override
    public void run() {

    }

    @Override
    public void run(Server args) {
        Server server = serverDao.editServer(args);

        System.out.println("Server details changed to " + server.getId() + server.getName());
    }
}
