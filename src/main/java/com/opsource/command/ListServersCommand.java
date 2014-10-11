package com.opsource.command;

import com.opsource.dao.ServerDao;
import com.opsource.dao.entities.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListServersCommand implements Command {

    @Autowired
    ServerDao serverDao;

    @Override
    public void run() {
        // TODO: change output when there are no servers in the DB
        System.out.println("Servers in the database: ");

        List<Server> servers = serverDao.listAllServers();

        for (Server server : servers){
            System.out.println(" # ID: " + server.getId() + " # Name: " + server.getName());
        }
    }

    @Override
    public void run(Server args) {}
}
