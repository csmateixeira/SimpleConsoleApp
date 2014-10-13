package com.opsource.views;

import com.opsource.model.Status;
import org.springframework.stereotype.Component;

/**
 * @author Carla Teixeira
 * View for countServers
 */
@Component
public class CountServersView implements View {

    /**
     * Renders the view
     * @param status status from the countServers command
     */
    @Override
    public void render(Status status) {
        System.out.println(status.getMessage());
    }
}
