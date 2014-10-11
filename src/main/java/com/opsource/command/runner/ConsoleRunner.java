package com.opsource.command.runner;

import com.opsource.command.AddServerCommand;
import com.opsource.command.HelpCommand;
import com.opsource.command.ListServersCommand;
import com.opsource.command.QuitCommand;
import com.opsource.pojo.XMLServerParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

@Controller
public class ConsoleRunner {

    @Autowired
    AddServerCommand addServerCommand;

    @Autowired
    HelpCommand helpCommand;

    @Autowired
    QuitCommand quitCommand;

    @Autowired
    ListServersCommand listServersCommand;

    public void listServers(){ listServersCommand.run(); }

    public void addServer(String file) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        addServerCommand.run(XMLServerParser.parse(file));
    }

    public void help() {
        helpCommand.run();
    }

    public void quit() {
        quitCommand.run();
    }

}
