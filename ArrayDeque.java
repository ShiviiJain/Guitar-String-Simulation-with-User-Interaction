package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    private static final int LIMIT = 8;
    private static final int LIMITS = 4;


    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int index = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            temp[i] = items[index];
            index = (index + 1) % items.length;
        }
        items = temp;
        nextFirst = capacity - 1;
        nextLast = size;
    }


    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[LIMIT];
        nextFirst = 0;
        nextLast = 1;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item; //adding item to the position of nextFirst which here is 0
        nextFirst = (nextFirst - 1 + items.length) % items.length; //circular array
        size = size + 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size = size + 1;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size(); i++) {
            if (items[i] == null) {
                System.out.println("\n");
            }
            System.out.print(items[i] + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if ((size < items.length / LIMITS) && size > LIMIT) {
            resize(items.length / 2);
        }
        nextFirst = (nextFirst + 1) % items.length;
        T first = items[nextFirst]; //first item
        items[nextFirst] = null;
        size = size - 1;
        return first;
    }
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if ((size < items.length / LIMITS) && size > LIMIT) {
            resize(items.length / 2);
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        T last = items[nextLast]; //last item
        items[nextLast] = null;
        size = size - 1;
        return last;
    }


    public T get(int index) {
        if (index < 0 || index > items.length) {
            return null;
        }
        return items[(((nextFirst + 1) % items.length) + index) % items.length];
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        if (o instanceof ArrayDeque) {
            ArrayDeque<T> array = (ArrayDeque<T>) o;
            if (array.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!(array.get(i).equals((this.get(i))))) {
                    return false;
                }
            }
        }
        return true;
    }


    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }
    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;
        public ArraySetIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T retitem = items[wizPos];
            wizPos = wizPos + 1;
            return retitem;
        }
    }

}






