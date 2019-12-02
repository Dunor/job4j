package ru.job4j.sort;

import java.util.*;

public class SortUser {
    public Set<User> sort (List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength (List<User> list) {
        Comparator comparator = new SortNameLengthComparator();
        Collections.sort(list, comparator);
        return list;
    }

    public List<User> sortByAllFields (List<User> list) {
        Comparator comparator = new SortByAllFieldsComparator();
        Collections.sort(list, comparator);
        return list;
    }
}
