package com.opsource.views;

import com.opsource.model.Status;
import org.springframework.stereotype.Component;

@Component
public class EditServerView implements View {

    @Override
    public void render(Status status) {

        if(status.isError())
            System.out.println("Could not edit server: " + status.getMessage() + ". Please check logs.");
        else
            System.out.println("Server edited: " + status.getMessage());
    }
}
