package TestPackage;

import java.io.IOException;

public class QueueStructure<T> {

    private Object[] array;
    private int size;

    public QueueStructure() {
        this.size = 0;
        this.array = new Object[5];

    }

    public void addElement(T value) {

        if (size == array.length) {

           Object[] newArray = new Object[array.length*2];

           for (int i = 0; i < size; i++) {
               newArray[i] = array[i];
           }

           array = newArray;

        }

        array[size] = value;
        size++;
    }

    /**
     * @throw can throw IllegalStateException
     */
    public void removeElement() {
        isEmpty();

        Object[] newArray = new Object[size-1];
        System.arraycopy(array, 1, newArray, 0,size-1);

        array = newArray;
        size--;
    }

    /**
     * @throw can throw IllegalStateException
     */
    public void printQueue() {
        isEmpty();

        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.print("]");
    }

    private void isEmpty() {
        if (size == 0) {
            throw new IllegalStateException("Array state is illegal");
        }
    }

    public T peek() {
        isEmpty();

        return (T) array[0];
    }

    public static void main(String[] args) {
        QueueStructure queue = new QueueStructure();
        queue.addElement(5);

        queue.printQueue();
    }
}
