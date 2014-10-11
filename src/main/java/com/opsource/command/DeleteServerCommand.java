package com.opsource.command;

import com.opsource.dao.ServerDao;
import com.opsource.dao.entities.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteServerCommand implements Command {

    @Autowired
    ServerDao serverDao;

    @Override
    public void run() { }

    @Override
    public void run(Server args) {
        serverDao.deleteServer(args);

        System.out.println("Deleted server ID: " + args.getId() + " name: " + args.getName());
    }
}
