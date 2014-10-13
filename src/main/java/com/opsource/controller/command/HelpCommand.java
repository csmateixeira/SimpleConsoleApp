package com.opsource.controller.command;

import com.opsource.model.Server;
import com.opsource.model.Status;
import org.springframework.stereotype.Component;

/**
 * @author Carla Teixeira
 * Command that implements help
 */
@Component
public class HelpCommand implements Command {

    /**
     * Runs the command
     * @return
     */
    @Override
    public Status run() {
        return new Status(false, "");
    }

    @Override
    public Status run(Server args) {
        return null;
    }


}
