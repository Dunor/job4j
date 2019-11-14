package ru.job4j.search;

import java.util.Comparator;
import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<Task>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        tasks.add(task);
        tasks.sort(new CompareTask());
    }

    public Task take() {
        return this.tasks.poll();
    }

    static class CompareTask implements Comparator<Task> {
        @Override
        public int compare(Task o1, Task o2) {
            return o1.getPriority() - o2.getPriority();
        }
    }
}
