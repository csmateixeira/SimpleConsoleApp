package com.opsource.dao;

import com.opsource.dao.repository.ServerRepository;
import com.opsource.pojo.exceptions.ServerNotFoundException;
import com.opsource.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServerDaoImpl implements ServerDao {

    @Autowired
    ServerRepository serverRepository;

    @Override
    public List<Server> listAllServers() {
        return serverRepository.findAll();
    }

    @Override
    public long countServers() {
        return serverRepository.count();
    }

    @Override
    public Server addServer(Server server) {
        return serverRepository.save(server);
    }

    @Override
    public Server editServer(Server server) throws ServerNotFoundException {
        Server updated = serverRepository.findOne(server.getId());

        if(updated == null)
            throw new ServerNotFoundException();

        updated.setName(server.getName());

        return serverRepository.save(updated);
    }

    @Override
    public void deleteServer(int server) {
        serverRepository.delete(server);
    }
}
