package com.opsource.dao;

import com.opsource.model.Server;
import com.opsource.pojo.exceptions.DuplicateServerException;
import com.opsource.pojo.exceptions.ServerNotFoundException;

import java.util.List;

public interface ServerDao {
    public List<Server> listAllServers();
    public long countServers();

    public Server addServer(Server server) throws DuplicateServerException;
    public Server editServer(Server server) throws ServerNotFoundException;
    public void deleteServer(int server) throws ServerNotFoundException;
}
