package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

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
        ArrayList<String> answers = new ArrayList<>();
        answers.add("Fix PC");
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        new CreateAction("Create a new Item").execute(input, tracker);
        Item created = tracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
       Tracker tracker = new Tracker();
       Item item = new Item("new item");
       tracker.add(item);
       ArrayList<String> answers = new ArrayList<>();
       answers.add(item.getId());
       answers.add("replaced item");
       new ReplaceAction("Replace Item").execute(new StubInput(answers), tracker);
       Item replaced = tracker.findById(item.getId());
       assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String id = item.getId();
        ArrayList<String> answers = new ArrayList<>();
        answers.add(id);
        new DeleteAction("Delete item").execute(new StubInput(answers), tracker);
        assertNull(tracker.findById(id));
    }

    @Test
    public void whenExit() {
        ArrayList<String> lst = new ArrayList<>();
        lst.add("0");
        StubInput input = new StubInput(lst);
        StubAction action = new StubAction();
        ArrayList<UserAction> al = new ArrayList<>();
        al.add(action);
        new StartUI().init(input, new Tracker(), al);
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenPrtMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        ArrayList<String> lst = new ArrayList<>();
        lst.add("0");
        StubInput input = new StubInput(lst);
        StubAction action = new StubAction();
        ArrayList<UserAction> al = new ArrayList<>();
        al.add(action);
        new StartUI().init(input, new Tracker(), al);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
