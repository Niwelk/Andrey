package TestPackage;

import java.util.ArrayList;

public class Stack {

    private ArrayList<Integer> storage;

    public Stack() {
        storage = new ArrayList<>();
    }

    public void push(Integer element) {
        storage.add(element);
    }

    public int pop() {

        if (storage.isEmpty()) {
            throw new IllegalStateException("нет элементов стеке");
        }

        int index = storage.size()-1;
        return storage.remove(index);
    }

    public int peek() {
        if (storage.isEmpty()) {
            throw new IllegalStateException("нет элементов стеке");
        }

        return storage.getLast();
    }
}
