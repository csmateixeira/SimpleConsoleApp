package com.opsource;

import com.opsource.pojo.Commands;
import com.sun.org.apache.bcel.internal.generic.SWITCH;

import java.io.DataInputStream;
import java.io.IOException;
import java.sql.SQLException;

public class MainApp {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        boolean running = true;

        showHelp();

        while (running) {
            DataInputStream in = new DataInputStream(System.in);
            String option = in.readLine();

            switch (Commands.getCommandFromCommandString(option)){
                case HELP:
                    showHelp(); break;
                case QUIT:
                    System.exit(0); break;
                case ADD_SERVER:
                    break;
                case DELETE_SERVER:
                    break;
                case COUNT_SERVERS:
                    break;
                case EDIT_SERVER:
                    break;
                case LIST_SERVERS:
                    break;
            }
        }
    }

    private static void showHelp() {
        System.out.println(Commands.HELP.getDescription());
        System.out.println(Commands.COUNT_SERVERS.getDescription());
        System.out.println(Commands.ADD_SERVER.getDescription());
        System.out.println(Commands.EDIT_SERVER.getDescription());
        System.out.println(Commands.DELETE_SERVER.getDescription());
        System.out.println(Commands.LIST_SERVERS.getDescription());
    }
}
