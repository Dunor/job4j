package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int i = 0;
        int j = 0;
        int cells = (int)Math.ceil((double)list.size() / rows);
        int[][] array = new int[rows][cells];
        for (Integer lst : list) {
            while (i < rows) {
                while ( j < cells) {
                    array[i][j] = lst;
                    j++;
                    break;
                }
                if (j < cells) {
                    break;
                } else {
                    j = 0;
                    i++;
                    break;
                }
            }
        }
        return array;
    }
}
