package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     *Основной цикл программы.
     */
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    /**
     * Меню.
     */
    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
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
        Input validate = new ValidateInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new FindAllAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByName(),
                new ExitAction()
        };
        new StartUI().init(validate, tracker, actions);
    }
}
