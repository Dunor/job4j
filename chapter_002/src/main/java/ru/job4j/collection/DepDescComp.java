package ru.job4j.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DepDescComp implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        ArrayList<String> arr1 = (new ArrayList<>(Arrays.asList(o1.split("/", 2))));
        ArrayList<String> arr2 = (new ArrayList<>(Arrays.asList(o2.split("/", 2))));
        int res;
        res = arr1.get(0).compareTo(arr2.get(0));
        if (res == 0) {
            if (arr1.size() < arr2.size()) {
                arr1.add("~");
            } else if (arr2.size() < arr1.size()) {
                arr2.add("~");
            }
            res = arr1.get(1).compareTo(arr2.get(1));
        }
        return res;
    }
}
