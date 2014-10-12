package com.opsource.service;

import com.opsource.controller.command.*;
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

@Service
@EnableTransactionManagement
@Transactional(rollbackFor = ServerNotFoundException.class)
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

    public void listServers(){ listServersCommand.run(); }
    public void countServers(){ countServersCommand.run(); }

    public void addServer(String file) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        addServerCommand.run(XMLServerParser.parse(file));
    }
    public void deleteServer(int id){ deleteServerCommand.run(new Server(id, null)); }
    public void editServer(int id, String name) { editServerCommand.run(new Server(id, name)); }

    public void help() {
        helpCommand.run();
    }

    public void quit() {
        quitCommand.run();
    }

}
