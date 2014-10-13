package com.opsource.controller.command;

import com.opsource.dao.ServerDao;
import com.opsource.model.Server;
import com.opsource.model.Status;
import com.opsource.pojo.Messages;
import com.opsource.pojo.exceptions.DuplicateServerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Carla Teixeira
 * Command that implements addServer
 */
@Component
public class AddServerCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    ServerDao serverDao;

    @Override
    public Status run() {
        return null;
    }

    /**
     * Runs the command
     * @param args command arguments (server to add)
     * @return status with added server id and name
     */
    @Override
    public Status run(Server args) {
        Server server = null;

        try {
            server = serverDao.addServer(args);

        } catch (DuplicateServerException e) {
            LOGGER.error(e.getMessage(), e);

            return new Status(true, " # " + e.getMessage());
        }

        String statusMessage =
                Messages.ID_AND_NAME
                        .replace(Messages.SERVER_ID, String.valueOf(server.getId()))
                        .replace(Messages.SERVER_NAME, server.getName());

        return new Status(false, statusMessage);
    }
}
