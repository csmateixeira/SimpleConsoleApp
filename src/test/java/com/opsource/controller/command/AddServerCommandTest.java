package com.opsource.controller.command;

import com.opsource.dao.ServerDao;
import com.opsource.model.Server;
import com.opsource.model.Status;
import com.opsource.pojo.Messages;
import com.opsource.pojo.exceptions.DuplicateServerException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AddServerCommandTest {

    @InjectMocks
    AddServerCommand addServerCommand;

    @Mock
    ServerDao serverDao;

    Status addStatus, errorAddStatus;
    Server server, server1;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        server = new Server(0, "name");
        server1 = new Server();

        addStatus = new Status(
                false,
                Messages.ID_AND_NAME
                        .replace(Messages.SERVER_ID, String.valueOf(server.getId()))
                        .replace(Messages.SERVER_NAME, server.getName())
        );

        errorAddStatus = new Status(
                true,
                " # " + (new DuplicateServerException()).getMessage()
        );

        doReturn(server).when(serverDao).addServer(server);
        doThrow(new DuplicateServerException()).when(serverDao).addServer(server1);

    }

    @Test
    public void shouldReturnAddedServer() throws Exception {

        Status status = addServerCommand.run(server);

        verify(serverDao).addServer(server);

        assertEquals(addStatus.isError(), status.isError());
        assertEquals(addStatus.getMessage(), status.getMessage());
    }

    @Test
    public void shouldReturnDuplicateServerExceptionMessage() throws Exception {
        Status status = addServerCommand.run(server1);

        verify(serverDao).addServer(server1);

        assertEquals(errorAddStatus.isError(), status.isError());
        assertEquals(errorAddStatus.getMessage(), status.getMessage());
    }
}
