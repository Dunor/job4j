package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите id завки: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка с id: " + id + " удалена.");
        } else {
            System.out.println("Заявка с id: " + id + " не удалена.");
        }
        return true;
    }
}
