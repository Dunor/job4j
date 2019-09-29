package ru.job4j.tracker;

import javax.sound.midi.Track;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа для добавления заявок.
     */
    private static final String ADD = "0";

    /**
     * Константа для вывода всех заявок.
     */
    private static final String SHOW = "1";

    /**
     * Константа для изменения заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа для поиска заявки по id.
     */
    private static final String FIND_BY_ID = "4";

    /**
     * Константа для для поиска заявки по имени.
     */
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для завершения программы.
     */
    private static final String EXIT = "6";

    /**
     *Основной цикл программы.
     */
    public void init(Input input, Tracker tracker) {
        boolean run = false;
        while (!run) {
            this.showMenu();
            String answer = input.askStr("Введите пункт меню: ");
            switch (answer) {
                case (ADD):
                    StartUI.createItem(input, tracker);
                    break;
                case (SHOW):
                    StartUI.showItems(tracker);
                    break;
                case (EDIT):
                    StartUI.replaceItem(input, tracker);
                    break;
                case (DELETE):
                    StartUI.deleteItem(input, tracker);
                    break;
                case (FIND_BY_ID):
                    StartUI.findByIdItem(input, tracker);
                    break;
                case (FIND_BY_NAME):
                    StartUI.findByNameItems(input, tracker);
                    break;
                case (EXIT):
                    run = true;
                    break;
                default:
                    System.out.println("Повторите ввод!");
            }
        }
    }

    /**
     * Меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find item by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        //String desc = input.askStr("Введите описание заявки :");
        Item item = new Item(name);
        tracker.add(item);
        //System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Выводит заявку в заданном представлении.
     * @param item - заявка
     */

    public static void showApplication(Item item) {
        System.out.println("=== Item ====");
        System.out.println("ID: " + item.getId());
        System.out.println("Name: " + item.getName());
       // System.out.println("Описание: " + item.getDesc());
        System.out.println();
    }

    /**
     * Метод реализует вывод заявок.
     */
    public static void showItems(Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item item : items) {
           showApplication(item);
        }
    }

    /**
     * Метод реализует редактирование заявки по id.
     */
    public static void replaceItem(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter name: ");
       // String desc = input.askStr("Введите описание заявки :");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменина.");
        } else {
            System.out.println("Заявка с id: " + id + " не найдена.");
        }
    }

    /**
     * Метод реализует поиск и вывод заявки по id.
     */
    public static void findByIdItem(Input input, Tracker tracker) {
        String id = input.askStr("Введите id завки: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с id: " + id + " не найдена.");
        } else {
            showApplication(item);
        }
    }

     /**
     * Метод реализует удаление заявки.
     */
    public static void deleteItem(Input input, Tracker tracker) {
        String id = input.askStr("Введите id завки: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка с id: " + id + " удалена.");
        } else {
            System.out.println("Заявка с id: " + id + " не удалена.");
        }
    }

     /**
     * Метод реализует поиск и вывод заявок по имени.
     */
    public static void findByNameItems(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки :");
        Item[] items = tracker.findByName(name);
        for (Item item : items) {
            showApplication(item);
        }

    }

    /**
     * Запускт программы.
     * @param args - args
     */
    public static void main(String[] args) {
        new StartUI().init(new ConsoleInput(), new Tracker());
    }
}
