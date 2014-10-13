package com.opsource.controller.command;

import com.opsource.model.Server;
import com.opsource.model.Status;
import org.springframework.stereotype.Component;

/**
 * @author Carla Teixeira
 * Command that implements quit
 */
@Component
public class QuitCommand implements Command {

    /**
     * Runs the command
     * @return
     */
    @Override
    public Status run() {

        System.exit(0);

        return null;
    }

    @Override
    public Status run(Server args) {
        return null;
    }
}
