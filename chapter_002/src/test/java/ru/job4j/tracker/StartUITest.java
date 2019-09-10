package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private  Tracker tracker;

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        tracker = new Tracker();     // создаём Tracker
    }

    @After
    public void backOutput() {
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserDeleteItemByID() {
        Item item = tracker.add(new Item("test name", "desc"));
        String id = item.getId();
        Input input = new StubInput(new String[]{"3", id, "заявка удалена", "6"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(id));
    }

    @Test
    public void whenShowAllItems() {
        Item item = tracker.add(new Item("test1", "desc1"));
        System.setOut(new PrintStream(this.out));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertTrue("",new String(out.toByteArray()).indexOf(new StringBuilder()
                        .append("-------- Заявка --------\r\n")
                        .append("ID: " + tracker.findAll()[0].getId() + "\r\n")
                        .append("Название: " + tracker.findAll()[0].getName() + "\r\n")
                        .append("Описание: " + tracker.findAll()[0].getDesc() + "\r\n")
                        .append(System.lineSeparator())
                        .toString()) != -1
        );
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserFindItemByName(){
        Item item = tracker.add(new Item("test1", "desc1"));
        String name = item.getName();
        System.setOut(new PrintStream(this.out));
        Input input = new StubInput(new String[]{"5", name, "6"});
        new StartUI(input, tracker).init();
        assertTrue("",new String(out.toByteArray()).indexOf(new StringBuilder()
                .append("-------- Заявка --------\r\n")
                .append("ID: " + tracker.findAll()[0].getId() + "\r\n")
                .append("Название: " + name + "\r\n")
                .append("Описание: " + tracker.findAll()[0].getDesc() + "\r\n")
                .append(System.lineSeparator())
                .toString()) != -1
        );
        System.setOut(this.stdout);
    }
}
