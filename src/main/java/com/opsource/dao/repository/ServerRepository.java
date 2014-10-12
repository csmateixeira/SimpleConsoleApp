package com.opsource.dao.repository;

import com.opsource.model.Server;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerRepository extends CrudRepository<Server, Integer>{

    List<Server> findAll();

}
