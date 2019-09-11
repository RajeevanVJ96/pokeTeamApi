package com.qa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PokeTeam {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    private int pid;

    public PokeTeam(){};

    public PokeTeam(int pid) {
        super();
        this.pid = pid;
    }

    public Long getId() {
        return id;
    }

    public int getPid(){return pid; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setPokeTeam(PokeTeam p){
        this.pid = p.pid;

    }










}
