package com.opsource.service;

import com.opsource.controller.command.*;
import com.opsource.model.Status;
import com.opsource.pojo.exceptions.DuplicateServerException;
import com.opsource.pojo.exceptions.InvalidServerIdException;
import com.opsource.pojo.exceptions.ServerNotFoundException;
import com.opsource.model.Server;
import com.opsource.pojo.XMLServerParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * @author Carla Teixeira
 * Service layer for the console that also acts as commands factory
 */
@Service
@EnableTransactionManagement
@Transactional(
        rollbackFor = {
            ServerNotFoundException.class,
            InvalidServerIdException.class,
            DuplicateServerException.class
        }
)
public class ConsoleService {

    @Autowired
    AddServerCommand addServerCommand;

    @Autowired
    HelpCommand helpCommand;

    @Autowired
    QuitCommand quitCommand;

    @Autowired
    ListServersCommand listServersCommand;

    @Autowired
    DeleteServerCommand deleteServerCommand;

    @Autowired
    EditServerCommand editServerCommand;

    @Autowired
    CountServersCommand countServersCommand;

    public Status listServers(){
        return listServersCommand.run();
    }

    public Status countServers(){
        return countServersCommand.run();
    }

    public Status addServer(String file)
            throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        return addServerCommand.run(XMLServerParser.parse(file));
    }

    public Status deleteServer(int id){
        return deleteServerCommand.run(new Server(id, null));
    }

    public Status editServer(int id, String name) {
        return editServerCommand.run(new Server(id, name));
    }

    public Status help() {
        return helpCommand.run();
    }

    public Status quit() {
        return quitCommand.run();
    }

}
