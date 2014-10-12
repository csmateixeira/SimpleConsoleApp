package com.opsource.controller.command;

import com.opsource.dao.ServerDao;
import com.opsource.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddServerCommand implements Command {

    @Autowired
    ServerDao serverDao;

    @Override
    public void run() {
    }

    @Override
    public void run(Server args) {
        // TODO: check if server exists to tell user it exists already
        Server server = serverDao.addServer(args);

        System.out.println("Added server ID: " + server.getId() + " name: " + server.getName());
    }
}
