package com.opsource;

import com.opsource.controller.ConsoleController;
import com.opsource.model.Commands;
import com.opsource.model.Status;
import com.opsource.views.HelpView;
import com.opsource.views.ViewFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.tools.jar.CommandLine;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Carla Teixeira
 */
public class MainApp {

    private static ApplicationContext applicationContext;
    private static ConsoleController consoleController;
    private static ViewFactory viewFactory;

    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
        consoleController = applicationContext.getAutowireCapableBeanFactory().getBean(ConsoleController.class);
        viewFactory = applicationContext.getAutowireCapableBeanFactory().getBean(ViewFactory.class);
    }

    public static void main(String[] args) {

        viewFactory.render(Commands.HELP, new Status());

        while (true) {

            // changing deprecated DataInputStream.readline with scanner
            try{
                Scanner scanIn = new Scanner(System.in);
                String option = scanIn.nextLine();

                consoleController.runConsole(option);

            } catch (NoSuchElementException e){
                System.err.println("execution interrupted");
                System.exit(1);
            }

        }
    }

}
