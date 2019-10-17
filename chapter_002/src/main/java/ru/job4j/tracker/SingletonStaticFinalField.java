package ru.job4j.tracker;

public class SingletonStaticFinalField {
    private static final Tracker INSTANCE = new Tracker();

    private SingletonStaticFinalField() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }
}
