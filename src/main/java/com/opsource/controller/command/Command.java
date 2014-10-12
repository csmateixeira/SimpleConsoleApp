package com.opsource.controller.command;

import com.opsource.model.Server;
import com.opsource.model.Status;

public interface Command {

    public Status run();
    public Status run(Server args);

}
