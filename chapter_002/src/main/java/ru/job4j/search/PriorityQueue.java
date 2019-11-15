package ru.job4j.search;

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
        if (tasks.size() != 0) {
            for (Task task1 : tasks) {
                if (task.getPriority() <= task1.getPriority()) {
                    tasks.add(tasks.indexOf(task1), task);
                    break;
                } else if (task.getPriority() >= tasks.getLast().getPriority()) {
                    tasks.addLast(task);
                    break;
                }
            }
        } else {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
