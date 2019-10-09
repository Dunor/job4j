package ru.job4j.tracker;

public class FindByIdAction extends BaseAction {
    protected FindByIdAction(String name) {
        super(name);
    }

   /* @Override
    public String name() {
        return "=== Find item by Id ====";
    }*/

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите id завки: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с id: " + id + " не найдена.");
        } else {
            StartUI.showApplication(item);
        }
        return true;
    }
}
