package com.opsource.controller;

import com.opsource.model.Commands;
import com.opsource.model.Status;
import com.opsource.pojo.Constants;
import com.opsource.pojo.exceptions.InvalidServerIdException;
import com.opsource.service.ConsoleService;
import com.opsource.views.ViewFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class ConsoleController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    ConsoleService consoleService;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ViewFactory viewFactory;

    public void runConsole(String option) {
        // get command and arguments
        String[] commandString = option.split(" ");

        Commands command = Commands.getCommandFromCommandString(commandString[0]);

        // NOTE: commands are now case insensitive
        switch (command) {
            case HELP:
                viewFactory.render(command, consoleService.help());
                break;
            case QUIT:
                consoleService.quit();
                break;
            case ADD_SERVER:
                viewFactory.render(command, addServer(commandString));
                break;
            case DELETE_SERVER:
                viewFactory.render(command, deleteServer(commandString));
                break;
            case COUNT_SERVERS:
                viewFactory.render(command, consoleService.countServers());
                break;
            case EDIT_SERVER:
                viewFactory.render(command, editServer(commandString));
                break;
            case LIST_SERVERS:
                viewFactory.render(command, consoleService.listServers());
                break;
            default:
                viewFactory.render(command, new Status());
                break;
        }
    }

    private Status editServer(String[] commandString) {

        try {
            if (commandString.length > 2)
                return consoleService.editServer(Integer.parseInt(commandString[1]), commandString[2]);
            else
                return new Status(true, "Server id and server name needed to edit server.");

        } catch (NumberFormatException e) {
            LOGGER.error(e.getMessage(), e);

            return new Status(true, " # " + e.getMessage());
        }
    }

    private Status deleteServer(String[] commandString) {
        try {
            if (commandString.length > 1)
                return consoleService.deleteServer(Integer.parseInt(commandString[1]));
            else
                return new Status(true, (new InvalidServerIdException()).getMessage());

        } catch (NumberFormatException e) {
            LOGGER.error(e.getMessage(), e);

            return new Status(true, " # " + e.getMessage());
        }
    }

    private Status addServer(String[] commandString) {

        try {
            String file = (commandString.length > 1) ? commandString[1] : Constants.DEFAULT_ADD_SERVER_FILE;

            Resource resource = applicationContext.getResource("classpath:" + file);
            String filePath = resource.getURL().getPath();

            return consoleService.addServer(filePath);

        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);

            return new Status(true, " # " + e.getMessage());

        } catch (XPathExpressionException e) {
            LOGGER.error(e.getMessage(), e);

            return new Status(true, " # " + e.getMessage());

        } catch (ParserConfigurationException e) {

            LOGGER.error(e.getMessage(), e);

            return new Status(true, " # " + e.getMessage());

        } catch (SAXException e) {
            LOGGER.error(e.getMessage(), e);

            return new Status(true, " # " + e.getMessage());

        }

    }
}
