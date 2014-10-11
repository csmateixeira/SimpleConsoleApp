package com.opsource.command;

import com.opsource.dao.entities.Server;

/**
 * Created by Nixka on 11/10/2014.
 */
public interface Command {

    public void run();
    public void run(Server args);

}
