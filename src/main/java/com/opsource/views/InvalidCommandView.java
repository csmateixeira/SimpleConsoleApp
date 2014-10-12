package com.opsource.views;

import com.opsource.model.Status;
import org.springframework.stereotype.Component;

@Component
public class InvalidCommandView implements View {

    @Override
    public void render(Status status) {
        System.out.println("Invalid command. Type help to list valid commands.");
    }
}
