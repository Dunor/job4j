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
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        new CreateAction().execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
       Tracker tracker = new Tracker();
       Item item = new Item("new item");
       tracker.add(item);
       String[] answers = {
         item.getId(),   // id сохраненной заявки в объект tracker.
         "replaced item"
       };
       new ReplaceAction().execute(new StubInput(answers), tracker);
       Item replaced = tracker.findById(item.getId());
       assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String id = item.getId();
        String[] answers = {
                id   // id сохраненной заявки в объект tracker.
        };
        new DeleteAction().execute(new StubInput(answers), tracker);
        assertNull(tracker.findById(id));
    }

    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] { action });
        assertThat(action.isCall(), is(true));
    }

   /* @Test
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
    }*/
}
