package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortUserTest {
    @Test
    public void whenSortByAge() {
        List<User> list = new ArrayList<>();
        SortUser sortUser = new SortUser();
        list.add(new User("Tom", 23));
        list.add(new User("Mike", 18));
        list.add(new User("John", 37));
        Set<User> result = sortUser.sort(list);
        TreeSet<User> expected = new TreeSet<>();
        expected.add(new User("Mike", 18));
        expected.add(new User("Tom", 23));
        expected.add(new User("John", 37));
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortNameLength() {
        ArrayList<User> list = new ArrayList<>();
        SortUser sortUser = new SortUser();
        list.add(new User("Sofia", 37));
        list.add(new User("Mike", 18));
        list.add(new User("Tom", 23));
        List<User> result = sortUser.sortNameLength(list);
        ArrayList<User> expected = new ArrayList<>();
        String rst = result.toString();
        expected.add(new User("Tom", 23));
        expected.add(new User("Mike", 18));
        expected.add(new User("Sofia", 37));
        String str = expected.toString();
        assertEquals(rst, str);
    }

    @Test
    public void whenSortByAllFields() {
        ArrayList<User> list = new ArrayList<>();
        SortUser sortUser = new SortUser();
        User tom = new User("Tom", 23);
        User sofia = new User("Sofia", 18);
        User john = new User("John", 37);
        User john1 = new User("John", 25);
        User john2 = new User("John", 13);
        User sofia2 = new User("Sofia", 13);
        list.add(new User("Tom", 23));
        list.add(new User("Sofia", 18));
        list.add(new User("John", 37));
        list.add(new User("John", 25));
        list.add(new User("John", 13));
        list.add(new User("Sofia", 13));
        List<User> result = sortUser.sortByAllFields(list);
        ArrayList<User> expected = new ArrayList<>();
        String rst = result.toString();
        expected.add(john2);
        expected.add(john1);
        expected.add(john);
        expected.add(sofia2);
        expected.add(sofia);
        expected.add(tom);
        String str = expected.toString();
        assertEquals(rst, str);
    }
}