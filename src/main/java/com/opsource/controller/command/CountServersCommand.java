package com.opsource.controller.command;

import com.opsource.dao.ServerDao;
import com.opsource.model.Server;
import com.opsource.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountServersCommand implements Command {

    @Autowired
    ServerDao serverDao;

    @Override
    public Status run() {
        return new Status(false, "# Found " + serverDao.countServers() + " server(s)");
    }

    @Override
    public Status run(Server args) {
        return null;
    }
}
