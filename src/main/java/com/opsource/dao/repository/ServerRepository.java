package com.opsource.dao.repository;

import com.opsource.dao.entities.Server;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerRepository extends CrudRepository<Server, Integer>{

    List<Server> findAll();

}
