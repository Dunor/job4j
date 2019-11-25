package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserConvertTest {

    @Test
    public void whenConvertListToMap() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Tom", "NY"));
        list.add(new User(2, "Ivan", "NSK"));
        Map<Integer, User> expect = new HashMap<>();
        expect.put(list.get(0).getId(), list.get(0));
        expect.put(list.get(1).getId(), list.get(1));
        Map<Integer, User> result = new UserConvert().process(list);
        assertThat(result, is(expect));
    }
}