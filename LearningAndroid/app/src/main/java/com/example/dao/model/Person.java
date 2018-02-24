package com.example.dao.model;

/**
 * Created by dao on 2/24/18.
 */
public class Person
{
    public Person(String name, String location) {
        this.name = name;
        this.location = location;
    }

    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoation() {
        return location;
    }

    public void setLoation(String loation) {
        this.location = loation;
    }

    @Override
    public String toString() {
        return name + "--" + location;
    }
}
