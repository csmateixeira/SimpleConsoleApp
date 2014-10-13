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
 * Command that implements deleteServer
 */
@Component
public class DeleteServerCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    ServerDao serverDao;

    @Override
    public Status run() {
        return null;
    }

    /**
     * Runs the command
     * @param args command arguments (server id to delete)
     * @return status with id of deleted server
     */
    @Override
    public Status run(Server args) {

        try {
            serverDao.deleteServer(args.getId());

        } catch (ServerNotFoundException e) {
            LOGGER.error(e.getMessage(), e);

            return new Status(true, " # " + e.getMessage());
        }

        String statusMessage =
                Messages.ID
                        .replace(Messages.SERVER_ID, String.valueOf(args.getId()));

        return new Status(false, statusMessage);
    }
}
