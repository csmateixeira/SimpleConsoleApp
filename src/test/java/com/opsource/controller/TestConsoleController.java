package com.opsource.controller;

import com.opsource.model.Commands;
import com.opsource.model.Status;
import com.opsource.pojo.ResourceLocator;
import com.opsource.service.ConsoleService;
import com.opsource.views.ViewFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class TestConsoleController {

    private static final Logger LOGGER = LogManager.getLogger();

    public static final String DEFAULT_FILE_XML = "server.xml";
    public static final String VALID_FILE_XML = "server_1.xml";
    public static final String INVALID_FILE_XML = "invalid_file.xml";

    public static final String ID_ID_NAME_NAME = " # id id # name name";
    public static final String FOUND_3_SERVERS = "# found 3 servers";

    @InjectMocks
    ConsoleController consoleController;

    @Mock
    ConsoleService consoleService;

    @Mock
    ViewFactory viewFactory;

    @Mock
    ResourceLocator resourceLocator;

    Status addStatus, editStatus, deleteStatus, countStatus, listStatus, helpStatus, quitStatus;

    @Before
    public void setUp() throws Exception {

        initMocks(this);

        mockService();
        mockViewFactory();
        mockResourceLocator();
    }

    @Test
    public void shouldCallHelpCommandAndRenderHelpView() throws Exception {
        consoleController.runConsole("help");

        verify(consoleService).help();
        verify(viewFactory).render(Commands.HELP, helpStatus);
    }

    @Test
    public void shouldCallQuitCommand() throws Exception {
        consoleController.runConsole("quit");

        verify(consoleService).quit();
        verifyZeroInteractions(viewFactory);
    }

    // TODO: negative testing for edit command
    @Test
    public void shouldCallEditCommandWithEnteredParameters() {
        consoleController.runConsole("editServer 1 newname");

        verify(consoleService).editServer(1, "newname");
        verify(viewFactory).render(Commands.EDIT_SERVER, editStatus);
    }


    // TODO: negative testing for add command
    @Test
    public void shouldCallAddCommandWithDefaultFile() throws Exception  {

        consoleController.runConsole("addServer");

        verify(consoleService).addServer("/" + DEFAULT_FILE_XML);
        verify(viewFactory).render(Commands.ADD_SERVER, addStatus);
    }

    @Test
    public void shouldCallAddCommandWithGivenFile() throws Exception {

        consoleController.runConsole("addServer " + VALID_FILE_XML);

        verify(consoleService).addServer("/" + VALID_FILE_XML);
        verify(viewFactory).render(Commands.ADD_SERVER, addStatus);
    }

    // TODO: testing for list, count, delete

    private void mockViewFactory() {
        doNothing().when(viewFactory).render(any(Commands.class), any(Status.class));
    }

    private void mockResourceLocator() throws IOException {
        when(resourceLocator.getResourcePath(DEFAULT_FILE_XML)).thenReturn("/" + DEFAULT_FILE_XML);
        when(resourceLocator.getResourcePath(VALID_FILE_XML)).thenReturn("/" + VALID_FILE_XML);
    }

    private void mockService() throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        addStatus = new Status(false, ID_ID_NAME_NAME);
        countStatus = new Status(false, FOUND_3_SERVERS);
        deleteStatus = new Status(false, ID_ID_NAME_NAME);
        editStatus = new Status(false, ID_ID_NAME_NAME);
        listStatus = new Status(false, ID_ID_NAME_NAME);
        helpStatus = new Status();
        quitStatus = new Status();

        doReturn(addStatus).when(consoleService).addServer(anyString());
        doReturn(countStatus).when(consoleService).countServers();
        doReturn(deleteStatus).when(consoleService).deleteServer(anyInt());
        doReturn(editStatus).when(consoleService).editServer(anyInt(), anyString());
        doReturn(listStatus).when(consoleService).listServers();

        doReturn(helpStatus).when(consoleService).help();
        doReturn(helpStatus).when(consoleService).quit();
    }

}
