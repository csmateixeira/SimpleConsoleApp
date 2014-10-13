package com.opsource.dao;

import com.opsource.dao.repository.ServerRepository;
import com.opsource.model.Server;
import com.opsource.pojo.exceptions.DuplicateServerException;
import com.opsource.pojo.exceptions.ServerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carla Teixeira
 * DAO class for database access
 */
@Component
public class ServerDaoImpl implements ServerDao {

    @Autowired
    ServerRepository serverRepository;

    /**
     * Gets all servers on the database
     * @return list of servers
     */
    @Override
    public List<Server> listAllServers() {
        return serverRepository.findAll();
    }

    /**
     * Counts servers on the database
     * @return number of servers
     */
    @Override
    public long countServers() {
        return serverRepository.count();
    }

    /**
     * Adds server to the database
     * @param server server details to add
     * @return saved server
     * @throws DuplicateServerException
     */
    @Override
    public Server addServer(Server server) throws DuplicateServerException {
        Server existing = serverRepository.findOne(server.getId());

        if (existing != null)
            throw new DuplicateServerException();

        return serverRepository.save(server);
    }

    /**
     * Edits server on the database
     * @param server server details to edit
     * @return edited server
     * @throws ServerNotFoundException
     */
    @Override
    public Server editServer(Server server) throws ServerNotFoundException {
        Server updated = serverRepository.findOne(server.getId());

        if (updated == null)
            throw new ServerNotFoundException();

        updated.setName(server.getName());

        return serverRepository.save(updated);
    }

    /**
     * deletes server from the database
     * @param server server id to delete
     * @throws ServerNotFoundException
     */
    @Override
    public void deleteServer(int server) throws ServerNotFoundException {
        Server existing = serverRepository.findOne(server);

        if (existing == null)
            throw new ServerNotFoundException();

        serverRepository.delete(server);
    }
}
