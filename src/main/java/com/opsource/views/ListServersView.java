package com.opsource.views;

import com.opsource.model.Status;
import org.springframework.stereotype.Component;

/**
 * @author Carla Teixeira
 * View for listServers
 */
@Component
public class ListServersView implements View {

    /**
     * Renders the view
     * @param status status from the listServers command
     */
    @Override
    public void render(Status status) {
        System.out.println("Servers in the database: ");
        System.out.println(status.getMessage());
    }
}
