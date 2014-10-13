package com.opsource.views;

import com.opsource.model.Status;
import org.springframework.stereotype.Component;

/**
 * @author Carla Teixeira
 * View for addServer
 */
@Component
public class AddServerView implements View {

    /**
     * Renders the view
     * @param status status from addServer command
     */
    @Override
    public void render(Status status) {

        if(status.isError())
            System.out.println("Could not add server: " + status.getMessage() + ". Please check logs.");
        else
            System.out.println("Server added: " + status.getMessage());
    }
}
