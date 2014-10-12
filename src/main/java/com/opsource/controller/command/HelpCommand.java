package com.opsource.controller.command;

import com.opsource.model.Server;
import com.opsource.model.Status;
import org.springframework.stereotype.Component;

@Component
public class HelpCommand implements Command {

    @Override
    public Status run() {
        return new Status(false, "");
    }

    @Override
    public Status run(Server args) {
        return null;
    }


}
