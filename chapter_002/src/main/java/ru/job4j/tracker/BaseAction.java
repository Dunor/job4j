package ru.job4j.tracker;

abstract class BaseAction implements UserAction{
    private final String name;
    protected BaseAction(final String name) {
        this.name = name;
    }

    public String name() {
        return String.format("=== %s ====",  this.name);
    }
}
