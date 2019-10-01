package ru.job4j.tracker;

public class ShowItemsAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
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
