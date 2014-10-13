package com.opsource.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ResourceLocator {

    @Autowired
    ApplicationContext applicationContext;

    public String getResourcePath(String resourceName) throws IOException {
        Resource resource = applicationContext.getResource("classpath:" + resourceName);
        String resourcePath = resource.getURL().getPath();

        return resourcePath;
    }
}
