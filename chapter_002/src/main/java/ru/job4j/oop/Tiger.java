package ru.job4j.oop;

public class Tiger extends Predator {
    public Tiger(String name) {
        super(name);
        System.out.println("load Tiger");
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger("Tig");
    }
}
