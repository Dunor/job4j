package ru.job4j.tracker;

public class CreateAction extends BaseAction {
    protected CreateAction(String name) {
        super(name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Enter name: ");
        String name = input.askStr("");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}
