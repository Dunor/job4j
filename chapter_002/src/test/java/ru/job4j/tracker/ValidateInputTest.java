package ru.job4j.tracker;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ArrayList<String> lst = new ArrayList<>();
        lst.add("invalid");
        lst.add("1");
        ValidateInput input = new ValidateInput(
                new StubInput(lst)
        );
        input.askInt("Enter", 2);
        assertThat(
                new String(mem.toByteArray()),
                is(String.format("Please enter validate data again.%n"))
        );
        System.setOut(out);
    }
    @Test
    public void whenInvalidInput2() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ArrayList<String> lst = new ArrayList<>();
        lst.add("10");
        lst.add("1");
        ValidateInput input = new ValidateInput(
                new StubInput(lst)
        );
        input.askInt("Enter", 2);
        assertThat(
                new String(mem.toByteArray()),
                is(String.format("Please select key from menu.%n"))
        );
        System.setOut(out);
    }

}
