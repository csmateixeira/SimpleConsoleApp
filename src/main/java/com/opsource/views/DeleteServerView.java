package com.opsource.views;

import com.opsource.model.Status;
import org.springframework.stereotype.Component;

@Component
public class DeleteServerView implements View {

    @Override
    public void render(Status status) {

        if(status.isError())
            System.out.println("Could not delete server: " + status.getMessage() + ". Please check logs.");
        else
            System.out.println("Server deleted: " + status.getMessage());
    }
}
