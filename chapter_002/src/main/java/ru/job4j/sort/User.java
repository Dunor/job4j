package ru.job4j.sort;

public class User implements Comparable<User> {
    private String name;
    private Integer age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.getAge());
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
