package ru.job4j.tracker;

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

    private final Input input;

    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     *Основной цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            switch (answer) {
                case (ADD):
                    this.createItem();
                    break;
                case (SHOW):
                    this.showItems();
                    break;
                case (EDIT):
                    this.editItem();
                    break;
                case (DELETE):
                    deleteItem();
                    break;
                case (FIND_BY_ID):
                    findByIdItem();
                    break;
                case (FIND_BY_NAME):
                    findByNameItems();
                    break;
                case (EXIT):
                    exit = true;
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
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Выводит заявку в заданном представлении.
     * @param item - заявка
     */

    private void showApplication(Item item) {
        System.out.println("-------- Заявка --------");
        System.out.println("ID: " + item.getId());
        System.out.println("Название: " + item.getName());
        System.out.println("Описание: " + item.getDesc());
        System.out.println();
    }

    /**
     * Метод реализует вывод заявок.
     */
    private void showItems() {
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
           showApplication(item);
        }
    }

    /**
     * Метод реализует редактирование заявки по id.
     */
    private void editItem() {
        String id = this.input.ask("Введите id завки, которую хотите изменить: ");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("Заявка изменина.");
        } else {
            System.out.println("Заявка с id: " + id + " не найдена.");
        }
    }

    /**
     * Метод реализует поиск и вывод заявки по id.
     */
    private void findByIdItem() {
        String id = this.input.ask("Введите id завки: ");
        Item item = this.tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с id: " + id + " не найдена.");
        } else {
            showApplication(item);
        }
    }

     /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        String id = this.input.ask("Введите id завки: ");
        if (this.tracker.delete(id)) {
            System.out.println("Заявка с id: " + id + " удалена.");
        } else {
            System.out.println("Заявка с id: " + id + " не удалена.");
        }
    }

     /**
     * Метод реализует поиск и вывод заявок по имени.
     */
    private void findByNameItems() {
        String name = this.input.ask("Введите имя заявки :");
        Item[] items = this.tracker.findByName(name);
        for (Item item : items) {
            showApplication(item);
        }

    }

    /**
     * Запускт программы.
     * @param args - args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
