package ru.job4j.tracker;

public class ExitAction extends BaseAction {
    protected ExitAction(String name) {
        super(name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
