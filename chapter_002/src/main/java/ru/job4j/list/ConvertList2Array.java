package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int i = 0;
        int j = 0;
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        for (Integer lst : list) {
            array[i][j] = lst;
            j++;
            if (j >= cells) {
                j = 0;
                i++;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] lst : list) {
            for (int elem: lst) {
                result.add(elem);
            }
        }
        return result;
    }
}
