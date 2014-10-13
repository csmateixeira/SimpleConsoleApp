package com.opsource.controller.command;

import com.opsource.model.Status;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.MockitoAnnotations.initMocks;

public class HelpCommandTest {

    @InjectMocks
    HelpCommand helpCommand;

    @Before
    public void setUp() throws Exception {

        initMocks(this);

    }

    @Test
    public void shouldReturnSuccessStatus(){
        Status status = helpCommand.run();

        assertFalse(status.isError());
        assertEquals("", status.getMessage());
    }
}
