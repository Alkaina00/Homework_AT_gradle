package ru.alfa.homework13;

import java.util.LinkedList;

public class AssaultQueue {
    private  LinkedList<String> queue;

    public AssaultQueue() {
        this.queue = new LinkedList<>();
    }

    public void addRecruit(String name) {
        queue.add(name);
        System.out.println("Добавлен в очередь: " + name);
    }

    public String retreatCoward() {
        String removed = queue.removeFirst();
        System.out.println("Удален из очереди: " + removed);
        return removed;
    }

    public void printQueue() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Очередь на вход: \n" + queue;
    }
}
