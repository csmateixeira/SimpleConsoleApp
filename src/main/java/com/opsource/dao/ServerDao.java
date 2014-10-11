package com.opsource.dao;

import com.opsource.dao.entities.Server;

import java.util.List;

public interface ServerDao {
    public List<Server> listAllServers();
    public long countServers();

    public Server addServer(Server server);
    public Server editServer(Server server);
    public void deleteServer(Server server);
}
