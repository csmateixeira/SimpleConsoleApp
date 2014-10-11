package com.opsource.command;

import com.opsource.dao.entities.Server;
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
