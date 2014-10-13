package com.opsource.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Carla Teixeira
 * Database entity
 */
@Entity(name = "SERVER")
public class Server{

    @Id
    @Column(name = "ID")
    // NOTE: DB seems to accept a way larger number than the one that Integer accepts as maximum
	private int id;

    @Column(name = "NAME")
    private String name;

	public Server(){}

	public Server(int id, String name ){
		this.id = id;
		this.name = name;
	}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}