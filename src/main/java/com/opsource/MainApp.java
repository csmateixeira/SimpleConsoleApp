package com.opsource;

import com.opsource.controller.ConsoleController;
import com.opsource.model.Commands;
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
    private static ConsoleController consoleController;

    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
        consoleController = applicationContext.getAutowireCapableBeanFactory().getBean(ConsoleController.class);
    }

    public static void main(String[] args) {

        while (true) {

            // changing deprecated DataInputStream.readline with scanner
            // NOTE: explain performance benefits
            Scanner scanIn = new Scanner(System.in);
            String option = scanIn.nextLine();

            consoleController.runConsole(option);


        }
    }

}
