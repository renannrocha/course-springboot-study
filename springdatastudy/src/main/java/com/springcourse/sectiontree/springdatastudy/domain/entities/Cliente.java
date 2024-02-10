package com.springcourse.sectiontree.springdatastudy.domain.entities;

import java.io.Serializable;

public class Cliente implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public Cliente(){
    }

    public Cliente(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
