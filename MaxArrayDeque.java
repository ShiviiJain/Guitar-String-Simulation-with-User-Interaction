package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator comp;

    public MaxArrayDeque(Comparator<T> c) {
        comp = c;
    }

    public T max() {
        if (isEmpty()) {
            return null;
        }
        int maxindex = 0;
        for (int i = 0; i < size(); i++) {
            if (comp.compare(get(i), get(maxindex)) > 0) {
                maxindex = i;
            }
        }
        return get(maxindex);

    }


    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T endmax = get(0);
        for (int i = 0; i < size(); i++) {
            T max = get(i);
            if (c.compare(max, endmax) > 0) {
                endmax = max;
            }
        }
        return endmax;
    }
}
