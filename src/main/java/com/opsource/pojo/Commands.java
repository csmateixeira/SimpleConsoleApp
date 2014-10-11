package com.opsource.pojo;

/**
 * Created by Nixka on 11/10/2014.
 */
public enum Commands {
    HELP ("help", "help to display this message"),
    QUIT ("quit", "quit to quit the program"),
    COUNT_SERVERS ("countServers", "countServers to display the current number of servers present"),
    ADD_SERVER ("addServer", "addServer to display the current number of servers present"),
    DELETE_SERVER ("deleteServer", "deleteServer to delete a server (takes one more arg - the id of the server to delete)"),
    EDIT_SERVER ("editServer", "editServer to change the name of a server identified by id (takes 2 additional args - the id and the new name)"),
    LIST_SERVERS ("listServers", "listServers to display details of all servers servers");

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

        return null;
    }
}
