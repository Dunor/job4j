package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UniteArraysTest {
    @Test
    public void whenTwoArraysOfTheSameLength() {
        UniteArrays uniteArrays = new UniteArrays();
        int[] left = new int[] {1, 4};
        int[] right = new int[] {2, 3};
        int[] expect = new int[] {1, 2, 3, 4};
        int[] result = uniteArrays.merge(left, right);
        assertThat(result, is(expect));
    }
    @Test
    public void whenTwoArraysOfDifferentLength() {
        UniteArrays uniteArrays = new UniteArrays();
        int[] left = new int[] {1, 4, 6, 9};
        int[] right = new int[] {2, 3};
        int[] expect = new int[] {1, 2, 3, 4, 6, 9};
        int[] result = uniteArrays.merge(left, right);
        assertThat(result, is(expect));
    }

}
