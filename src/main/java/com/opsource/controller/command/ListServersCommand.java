package com.opsource.controller.command;

import com.opsource.dao.ServerDao;
import com.opsource.model.Server;
import com.opsource.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListServersCommand implements Command {

    @Autowired
    ServerDao serverDao;

    @Override
    public Status run() {
        List<Server> servers = serverDao.listAllServers();

        if(servers == null || servers.isEmpty())
            return new Status(false, " # no servers in database");

        String message = "";

        for (Server server : servers){
            message += " # id: " + server.getId() + " # id: " + server.getName();
            message += System.lineSeparator();
        }

        return new Status(false, message);
    }

    @Override
    public Status run(Server args) {
        return null;
    }
}
