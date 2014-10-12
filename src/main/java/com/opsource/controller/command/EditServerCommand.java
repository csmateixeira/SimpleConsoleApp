package com.opsource.controller.command;

import com.opsource.dao.ServerDao;
import com.opsource.model.Server;
import com.opsource.pojo.exceptions.ServerNotFoundException;
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

        try {
            Server server = serverDao.editServer(args);
            System.out.println("Server details changed to " + server.getId() + " " + server.getName());

        } catch (ServerNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}
