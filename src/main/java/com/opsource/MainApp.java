package com.opsource;

import com.opsource.command.runner.ConsoleRunner;
import com.opsource.pojo.Commands;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {

    private static ApplicationContext applicationContext;
    private static ConsoleRunner consoleRunner;

    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
        consoleRunner = applicationContext.getAutowireCapableBeanFactory().getBean(ConsoleRunner.class);
    }

    // FIXME: exceptions should not be thrown but rather handled gracefully
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, XPathExpressionException, ParserConfigurationException, SAXException, URISyntaxException {
        showHelp();

        while (true) {

            // changing deprecated DataInputStream.readline with scanner
            // TODO: explain performance benefits
            Scanner scanIn = new Scanner(System.in);
            String option = scanIn.nextLine();

            // TODO: explain why switch w/ enum is better that comparing on strings directly
            // NOTE: commands are now case insensitive
            // TODO: make add server accept file as an argument
            switch (Commands.getCommandFromCommandString(option)){
                case HELP:
                    consoleRunner.help(); break;
                case QUIT:
                    consoleRunner.quit(); break;
                case ADD_SERVER:
                    consoleRunner.addServer(getFilePath("server_1.xml")); break;
                case DELETE_SERVER:
                    break;
                case COUNT_SERVERS:
                    break;
                case EDIT_SERVER:
                    break;
                case LIST_SERVERS:
                    consoleRunner.listServers(); break;
            }
        }
    }

    private static String getFilePath(String fileName) throws URISyntaxException, IOException {
        Resource resource = applicationContext.getResource("classpath:" + fileName);

        return resource.getURL().getPath();
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
