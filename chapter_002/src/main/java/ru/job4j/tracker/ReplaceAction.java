package ru.job4j.tracker;

public class ReplaceAction extends BaseAction {
    protected ReplaceAction(String name) {
        super(name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменина.");
        } else {
            System.out.println("Заявка с id: " + id + " не найдена.");
        }
        return true;
    }
}
