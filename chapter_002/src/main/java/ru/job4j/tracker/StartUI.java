package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     *Основной цикл программы.
     */
    public void init(Input input, Tracker tracker, ArrayList<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    /**
     * Меню.
     */
    private void showMenu(ArrayList<UserAction> actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    /**
     * Выводит заявку в заданном представлении.
     * @param item - заявка
     */

    public static void showApplication(Item item) {
        System.out.println("=== Item ====");
        System.out.println("ID: " + item.getId());
        System.out.println("Name: " + item.getName());
    }

    /**
     * Запускт программы.
     * @param args - args
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction("Create a new Item"));
        actions.add(new FindAllAction("Show all items"));
        actions.add(new ReplaceAction("Replace Item"));
        actions.add(new DeleteAction("Delete item"));
        actions.add(new FindByIdAction("Find item by Id"));
        actions.add(new FindByName("Find items by name"));
        actions.add(new ExitAction("Exit program"));
        new StartUI().init(validate, tracker, actions);
    }
}
