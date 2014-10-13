package com.opsource.views;

import com.opsource.model.Status;
import org.springframework.stereotype.Component;

/**
 * @author Carla Teixeira
 * View for deleteServer
 */
@Component
public class DeleteServerView implements View {

    /**
     * Renders the view
     * @param status status from the deleteServer command
     */
    @Override
    public void render(Status status) {

        if(status.isError())
            System.out.println("Could not delete server: " + status.getMessage() + ". Please check logs.");
        else
            System.out.println("Server deleted: " + status.getMessage());
    }
}
