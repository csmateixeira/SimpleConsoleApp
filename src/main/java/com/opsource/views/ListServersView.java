package com.opsource.views;

import com.opsource.model.Status;
import org.springframework.stereotype.Component;

@Component
public class ListServersView implements View {

    @Override
    public void render(Status status) {
        System.out.println("Servers in the database: ");
        System.out.println(status.getMessage());
    }
}
