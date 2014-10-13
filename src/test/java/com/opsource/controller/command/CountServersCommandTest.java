package com.opsource.controller.command;

import com.opsource.dao.ServerDao;
import com.opsource.model.Status;
import com.opsource.pojo.Messages;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class CountServersCommandTest {

    @InjectMocks
    CountServersCommand countServersCommand;

    @Mock
    ServerDao serverDao;

    @Before
    public void setUp() throws Exception {

        initMocks(this);

        mockServerDao();
    }

    @Test
    public void shouldReturnServerCountMessage() throws Exception {
        Status status = countServersCommand.run();

        verify(serverDao).countServers();

        String expected =
                Messages.FOUND_COUNT_SERVERS
                    .replace(Messages.SERVER_COUNT, String.valueOf(3L));

        assertNotNull(status);
        assertEquals(expected, status.getMessage());
        assertFalse(status.isError());
    }

    private void mockServerDao() {
        doReturn(3L).when(serverDao).countServers();
    }
}
