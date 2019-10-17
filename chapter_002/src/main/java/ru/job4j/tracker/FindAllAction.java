package ru.job4j.tracker;

public class FindAllAction extends BaseAction {
    protected FindAllAction(String name) {
        super(name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item item : items) {
            StartUI.showApplication(item);
        }
        return true;
    }
}
