package com.opsource.model;

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

    public static Commands getCommandFromCommandString(String command){

        for (Commands c : values()){
            if(c.getCommand().equalsIgnoreCase(command))
                return c;
        }

        return INVALID_COMMAND;
    }
}
