package ru.job4j.tracker;

public class DeleteAction extends BaseAction {
    protected DeleteAction(String name) {
        super(name);
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
