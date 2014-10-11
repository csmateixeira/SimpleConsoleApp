package com.opsource.dao;

import com.opsource.dao.entities.Server;
import com.opsource.dao.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@EnableTransactionManagement
public class ServerDaoImpl implements ServerDao {

    @Autowired
    ServerRepository serverRepository;

    @Override
    @Transactional
    public List<Server> listAllServers() {
        return serverRepository.findAll();
    }

    @Override
    public long countServers() {
        return serverRepository.count();
    }

    @Override
    @Transactional
    public Server addServer(Server server) {
        return serverRepository.save(server);
    }

    @Override
    @Transactional
    public Server editServer(Server server) {
        return serverRepository.save(server);
    }

    @Override
    @Transactional
    public void deleteServer(Server server) {
        serverRepository.delete(server);
    }
}
