package com.opsource.views;

import com.opsource.model.Status;
import org.springframework.stereotype.Component;

/**
 * @author Carla Teixeira
 * View for editServer
 */
@Component
public class EditServerView implements View {

    /**
     * Renders the view
     * @param status status from the editServer command
     */
    @Override
    public void render(Status status) {

        if(status.isError())
            System.out.println("Could not edit server: " + status.getMessage() + ". Please check logs.");
        else
            System.out.println("Server edited: " + status.getMessage());
    }
}
