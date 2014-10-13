package com.opsource.views;

import com.opsource.model.Status;
import org.springframework.stereotype.Component;

/**
 * @author Carla Teixeira
 * View for invalid commands
 */
@Component
public class InvalidCommandView implements View {

    /**
     * Renders the view
     * @param status
     */
    @Override
    public void render(Status status) {
        System.out.println("Invalid command. Type help to list valid commands.");
    }
}
