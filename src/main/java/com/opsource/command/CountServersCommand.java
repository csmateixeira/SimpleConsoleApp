package com.opsource.command;

import com.opsource.dao.ServerDao;
import com.opsource.dao.entities.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountServersCommand implements Command {

    @Autowired
    ServerDao serverDao;

    @Override
    public void run() {
        System.out.println("Currently (" + serverDao.countServers() + ") server(s) in the database");
    }

    @Override
    public void run(Server args) {

    }
}
