package ru.job4j.list;

public class User {
    private int id;
    private String name;
    private String city;

    User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }




}
