package ru.job4j.sort;

import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
}