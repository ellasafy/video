package com.cstor.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {
    private int id;
    private String name;
    @Override
    public String toString() {
        return "Account [id=" + id + ", name=" + name + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    

}
