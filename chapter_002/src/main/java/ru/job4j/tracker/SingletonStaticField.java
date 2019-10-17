package ru.job4j.tracker;

public class SingletonStaticField {
    private static Tracker instance;

    SingletonStaticField() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
