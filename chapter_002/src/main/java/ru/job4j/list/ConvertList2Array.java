package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = ((list.size() - (int)Math.ceil(list.size() / rows) * rows) + list.size()) / rows;
        int[][] array = new int[rows][cells];
        return array;
    }
}
