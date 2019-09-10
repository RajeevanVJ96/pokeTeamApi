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
    String name;
    int pid;
    String m1;
    String m2;
    String m3;
    String m4;

    public PokeTeam(){};

    public PokeTeam(String name, int pid, String m1, String m2, String m3, String m4) {
        this.name = name;
        this.pid = pid;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public String getM3() {
        return m3;
    }

    public void setM3(String m3) {
        this.m3 = m3;
    }

    public String getM4() {
        return m4;
    }

    public void setM4(String m4) {
        this.m4 = m4;
    }

    public void setPokeTeam(PokeTeam p){
        this.name = p.name;
        this.pid = p.pid;
        this.m1 = p.m1;
        this.m2 = p.m2;
        this.m3 = p.m3;
        this.m4 = p.m4;
    }










}
