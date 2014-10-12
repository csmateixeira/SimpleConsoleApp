package com.opsource.controller.command;

import com.opsource.model.Server;
import org.springframework.stereotype.Component;

@Component
public class QuitCommand implements Command {

    @Override
    public void run() {
        System.exit(0);
    }

    @Override
    public void run(Server args) {

    }
}
