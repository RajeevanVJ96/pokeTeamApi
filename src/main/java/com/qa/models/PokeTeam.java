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
    private String name;
    private int pid1;
    private int pid2;
    private int pid3;
    private int pid4;
    private int pid5;
    private int pid6;

    public PokeTeam(){};

    public PokeTeam(String name, int pid1, int pid2, int pid3, int pid4, int pid5, int pid6) {
        super();
        this.name = name;
        this.pid1 = pid1;
        this.pid2 = pid2;
        this.pid3 = pid3;
        this.pid4 = pid4;
        this.pid5 = pid5;
        this.pid6 = pid6;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid1() {
        return pid1;
    }

    public void setPid1(int pid1) {
        this.pid1 = pid1;
    }

    public int getPid2() {
        return pid2;
    }

    public void setPid2(int pid2) {
        this.pid2 = pid2;
    }

    public int getPid3() {
        return pid3;
    }

    public void setPid3(int pid3) {
        this.pid3 = pid3;
    }

    public int getPid4() {
        return pid4;
    }

    public void setPid4(int pid4) {
        this.pid4 = pid4;
    }

    public int getPid5() {
        return pid5;
    }

    public void setPid5(int pid5) {
        this.pid5 = pid5;
    }

    public int getPid6() {
        return pid6;
    }

    public void setPid6(int pid6) {
        this.pid6 = pid6;
    }

    public void setPokeTeam(PokeTeam p){
        this.name = p.name;
        this.pid1 = p.pid1;
        this.pid2 = p.pid2;
        this.pid3 = p.pid3;
        this.pid4 = p.pid4;
        this.pid5 = p.pid5;
        this.pid6 = p.pid6;
    }










}
