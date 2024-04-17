package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class IntNode {
        private IntNode prev;
        private T item;
        private IntNode next;
        public IntNode(IntNode p, T i,  IntNode n) {
            prev = p;
            item = i;
            next = n;
        } }
    private IntNode sentinel;
    private int size;
    public LinkedListDeque() {
        size = 0;
        sentinel = new IntNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;

    }

    public void addFirst(T item) {
        sentinel.next = new IntNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        sentinel.next.prev = sentinel;
        size = size + 1;
    }

    public void addLast(T item) {
        IntNode p = new IntNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size = size + 1;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size(); i++) {
            if (sentinel.next == null) {
                System.out.println("\n");
            }
            System.out.print(sentinel.next.item + " ");
            sentinel.next = sentinel.next.next;
        }
    }

    public T removeFirst() {
        IntNode p = sentinel.next;
        if (size == 0 || p == null) {
            return null;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size = size - 1;
        return p.item;
    }

    public T removeLast() {
        IntNode p = sentinel.prev;
        if (size == 0 || p == null) {
            return null;
        }
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size = size - 1;
        return p.item;

    }

    public T get(int index) {
        IntNode p = sentinel.next;
        if (index < 0 || index >= size) {
            return null;
        } else {
            while (index > 0 && index < size) {
                p = p.next;
                index--;
            }
            return p.item;
        }

    }


    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Deque) {
            Deque<T> lld = (Deque<T>) o;
            if (lld.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!(lld.get(i).equals(get(i)))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public T getRecursive(int index) {
        return helperrecursiveget(sentinel.next, index);
    }

    private T helperrecursiveget(IntNode p, int index) { //helper to update the next value of sentinel
        if (index == 0) {
            return p.item;
        }
        return helperrecursiveget(p.next, index - 1);

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
            T retitem = get(wizPos);
            wizPos = wizPos + 1;
            return retitem;
        }
    }
}



