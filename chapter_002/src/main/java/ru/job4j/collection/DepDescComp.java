package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        int res = 0;
        int rstComp = Integer.compare(o1.length(), o2.length());
        String str = o1.length() < o2.length() ? o1 : o2;
        for (int i = 0; i < str.length(); i++) {
            res = Character.compare(o2.charAt(i), o1.charAt(i));
            if (res != 0) {
                break;
            } else if ((i == str.length() - 1) && (rstComp != 0)) {
                    res = o1.length() - o2.length();
            }

        }
        return res;
    }
}
