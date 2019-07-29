package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int size = array.length - 1;
        int tmp;
        for (int index = 0; index <= size; index++, size--) {
            tmp = array[index];
            array[index] = array[size];
            array[size] = tmp;
        }
        return array;
    }
}
