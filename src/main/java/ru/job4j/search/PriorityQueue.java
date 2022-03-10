package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    int index = 0;
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        for (Task element: tasks) {
            if (task.getPriority() > element.getPriority()) {
                index++;
            }
            break;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
