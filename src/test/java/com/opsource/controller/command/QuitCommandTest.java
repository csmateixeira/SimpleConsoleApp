package com.opsource.controller.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;

public class QuitCommandTest {

    // NOTE: using System Rules framework to test system exits calls - http://stefanbirkner.github.io/system-rules/

    @InjectMocks
    QuitCommand quitCommand;

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() throws Exception {

        initMocks(this);

    }

    @Test
    public void shouldReturnSuccessStatus(){
        exit.expectSystemExit();
        quitCommand.run();
    }
}
