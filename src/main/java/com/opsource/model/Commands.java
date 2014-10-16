package com.opsource.model;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Carla Teixeira
 * Possible commands and their descriptions
 */
public enum Commands {
    HELP ("help", "displays this message"),
    QUIT ("quit", "quits the program"),
    COUNT_SERVERS ("countServers", "displays the current number of servers present"),
    ADD_SERVER ("addServer", "adds server based on a configuration file (in the resources directory)"),
    DELETE_SERVER ("deleteServer", "deletes a server identified by a given id"),
    EDIT_SERVER ("editServer", "changes the name of a server identified by a given id"),
    LIST_SERVERS ("listServers", "displays details of all servers present"),

    INVALID_COMMAND ("invalid", "invalid command placeholder");

    private String command, description;

    Commands(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Get command details from command name
     * @param command command name
     * @return command details
     */
    public static Commands getCommandFromCommandString(String command){

        if(StringUtils.isEmpty(command))
            return INVALID_COMMAND;

        for (Commands c : values()){
            if(c.getCommand().equalsIgnoreCase(command))
                return c;
        }

        return INVALID_COMMAND;
    }
}
