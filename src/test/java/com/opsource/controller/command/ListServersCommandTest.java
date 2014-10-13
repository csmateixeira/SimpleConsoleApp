package com.opsource.controller.command;

import com.opsource.dao.ServerDao;
import com.opsource.model.Server;
import com.opsource.model.Status;
import com.opsource.pojo.Messages;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class ListServersCommandTest {

    @InjectMocks
    ListServersCommand listServersCommand;

    @Mock
    ServerDao serverDao;

    Server server, server1;

    @Before
    public void setUp() throws Exception {

         initMocks(this);

        server = new Server(0, "name");
        server1 = new Server(1, "name1");
    }

    @Test
    public void shouldReturnServerList(){
        List<Server> serverlist = new ArrayList<Server>(){{
            add(server);
            add(server1);
        }};

        doReturn(serverlist).when(serverDao).listAllServers();

        String expectedMessage =
                Messages.ID_AND_NAME
                        .replace(Messages.SERVER_ID, String.valueOf(server.getId()))
                        .replace(Messages.SERVER_NAME, server.getName()) +
                System.lineSeparator() +
                        Messages.ID_AND_NAME
                                .replace(Messages.SERVER_ID, String.valueOf(server1.getId()))
                                .replace(Messages.SERVER_NAME, server1.getName()) +
                System.lineSeparator();

        Status status = listServersCommand.run();

        verify(serverDao).listAllServers();

        assertEquals(expectedMessage, status.getMessage());
        assertFalse(status.isError());
    }

    @Test
    public void shouldReturnNoServersFound(){
        doReturn(new ArrayList<Server>()).when(serverDao).listAllServers();

        String expectedMessage = Messages.NO_SERVERS_FOUND_MESSAGE;

        Status status = listServersCommand.run();

        verify(serverDao).listAllServers();

        assertEquals(expectedMessage, status.getMessage());
        assertFalse(status.isError());
    }

}
