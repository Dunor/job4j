package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] arr1: array ) {
            for ( int arr2 : arr1) {
                list.add(arr2);
            }
        }
        return list;
    }
}
