package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rst = 0;
        int rstComp = Integer.compare(left.length(), right.length());
        String str = left.length() < right.length() ? left : right;
        for (int i = 0; i < str.length(); i++) {
           rst = Character.compare(left.charAt(i), right.charAt(i));
           if (rst != 0) {
               break;
           } else if ((i == str.length() - 1) && (rstComp != 0)) {
               if (rstComp < 0) {
                   rst = -1;
               } else {
                   rst = 1;
               }
           }
        }
        return rst;
    }
}
