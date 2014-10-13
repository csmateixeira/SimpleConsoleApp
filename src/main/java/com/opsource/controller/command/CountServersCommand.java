package com.opsource.controller.command;

import com.opsource.dao.ServerDao;
import com.opsource.model.Server;
import com.opsource.model.Status;
import com.opsource.pojo.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountServersCommand implements Command {

    @Autowired
    ServerDao serverDao;

    @Override
    public Status run() {
        String statusMessage =
                Messages.FOUND_COUNT_SERVERS
                        .replace(Messages.SERVER_COUNT, String.valueOf(serverDao.countServers()));

        return new Status(false, statusMessage);
    }

    @Override
    public Status run(Server args) {
        return null;
    }
}
