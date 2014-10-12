package com.opsource.controller;

import com.opsource.model.Commands;
import com.opsource.pojo.Constants;
import com.opsource.service.ConsoleService;
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
    @Autowired
    ConsoleService consoleService;

    @Autowired
    ApplicationContext applicationContext;

    public void runConsole(String option) {
        // get command arguments
        String[] commandString = option.split(" ");

        Commands command = Commands.getCommandFromCommandString(commandString[0]);

        if(command != null) {
            // TODO: explain why switch w/ enum is better that comparing on strings directly
            // NOTE: commands are now case insensitive
            // TODO: extract views from the controller
            switch (command) {
                case HELP:
                    consoleService.help();
                    break;
                case QUIT:
                    consoleService.quit();
                    break;
                case ADD_SERVER:
                    addServer(commandString);
                    break;
                case DELETE_SERVER:
                    // TODO: deal with the case of an id entered not being a valid int
                    if(commandString.length > 1) consoleService.deleteServer(Integer.valueOf(commandString[1]));
                    else System.out.println("Please enter a valid id to be deleted. Type help to list valid commands.");
                    break;
                case COUNT_SERVERS:
                    consoleService.countServers();
                    break;
                case EDIT_SERVER:
                    // TODO: deal with the case of an id entered not being a valid int
                    if (commandString.length > 2) consoleService.editServer(Integer.valueOf(commandString[1]), commandString[2]);
                    else System.out.println("Please enter a valid id to be changed and the new name. Type help to list valid commands.");
                    break;
                case LIST_SERVERS:
                    consoleService.listServers();
                    break;
                default:
                    consoleService.help();
                    break;
            }

        } else System.out.println("Invalid command. Type help to list valid commands.");
    }

    private void addServer(String[] commandString){
        // TODO: throw a warning if no file provided - default to server.xml
        // TODO: put constant in constants class
        try {
            String file = (commandString.length > 1) ? commandString[1] : Constants.DEFAULT_ADD_SERVER_FILE;
            consoleService.addServer(getFilePath(file));

        } catch (IOException e) {
            System.out.println("Error occurred when adding server from file: " + e.getMessage() + ". Check logs for more details.");

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private String getFilePath(String fileName) throws URISyntaxException, IOException {
        Resource resource = applicationContext.getResource("classpath:" + fileName);
        return resource.getURL().getPath();
    }
}
