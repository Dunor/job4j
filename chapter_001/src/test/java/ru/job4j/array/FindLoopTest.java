package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }
@Test
    public void whenArrayHasNotElement() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 6;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
@Test
    public void whenArrayHasElementInRange() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 8, 89, 6, 1};
        int value = 6;
        int start = 2;
        int finish = 5;
        int result = find.indexOf(input, value, start, finish);
        int expect = 5;
        assertThat(result, is(expect));
    }
@Test
    public void whenArrayHasNotElementInRange() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 8, 89, 6, 1};
        int value = 10;
        int start = 2;
        int finish = 5;
        int result = find.indexOf(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }


}
