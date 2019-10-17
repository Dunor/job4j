package ru.job4j.tracker;

public class FindByName extends BaseAction {
    protected FindByName(String name) {
        super(name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки :");
        Item[] items = tracker.findByName(name);
        for (Item item : items) {
            StartUI.showApplication(item);
        }
        return true;
    }
}
