package com.opsource.controller.command;

import com.opsource.dao.ServerDao;
import com.opsource.model.Server;
import com.opsource.model.Status;
import com.opsource.pojo.Messages;
import com.opsource.pojo.exceptions.ServerNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Carla Teixeira
 * Command that implements editServer
 */
@Component
public class EditServerCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    ServerDao serverDao;

    @Override
    public Status run() {
        return null;
    }

    /**
     * Runs the command
     * @param args command arguments (server id and new name)
     * @return status with edited server id and new name
     */
    @Override
    public Status run(Server args) {

        Server server = null;

        try {
            server = serverDao.editServer(args);

        } catch (ServerNotFoundException e) {
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
