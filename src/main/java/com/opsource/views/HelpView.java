package com.opsource.views;

import com.opsource.model.Commands;
import com.opsource.model.Status;
import org.springframework.stereotype.Component;

/**
 * @author Carla Teixeira
 * @see com.opsource.views.View
 */
@Component
public class HelpView implements View{

    /**
     * Renders the help view
     * @param status Status returned by the command
     */
    @Override
    public void render(Status status) {

        System.out.println("####################################################");

        // # HELP command
        String helpMessage =
                Commands.HELP.getCommand() + ": " +
                Commands.HELP.getDescription() +
                System.lineSeparator() +
                "\t\tUsage: help";

        System.out.println(helpMessage);

        // # COUNT_SERVERS command
        String countServersMessage =
                Commands.COUNT_SERVERS.getCommand() + ": " +
                        Commands.COUNT_SERVERS.getDescription() +
                        System.lineSeparator() +
                        "\t\tUsage: countServers";

        System.out.println(countServersMessage);

        // # ADD_SERVER command
        String addServerMessage =
                Commands.ADD_SERVER.getCommand() + ": " +
                        Commands.ADD_SERVER.getDescription() +
                        System.lineSeparator() +
                        "\t\tUsage: addServer <configFileName | nothing>" +
                        System.lineSeparator() +
                        "\t\tIf nothing is specified default file name is server.xml";

        System.out.println(addServerMessage);

        // # EDIT_SERVER command
        String editServerMessage =
                Commands.EDIT_SERVER.getCommand() + ": " +
                        Commands.EDIT_SERVER.getDescription() +
                        System.lineSeparator() +
                        "\t\tUsage: editServer <id> <newName>";

        System.out.println(editServerMessage);

        // # DELETE_SERVER command
        String deleteServerMessage =
                Commands.DELETE_SERVER.getCommand() + ": " +
                        Commands.DELETE_SERVER.getDescription() +
                        System.lineSeparator() +
                        "\t\tUsage: deleteServer <id>";

        System.out.println(deleteServerMessage);

        // # LIST_SERVERS command
        String listServersMessage =
                Commands.LIST_SERVERS.getCommand() + ": " +
                        Commands.LIST_SERVERS.getDescription() +
                        System.lineSeparator() +
                        "\t\tUsage: listServers";

        System.out.println(listServersMessage);

        // # QUIT command
        String quitMessage =
                Commands.QUIT.getCommand() + ": " +
                        Commands.QUIT.getDescription() +
                        System.lineSeparator() +
                        "\t\tUsage: quit";

        System.out.println(quitMessage);

        System.out.println("####################################################");
    }
}
