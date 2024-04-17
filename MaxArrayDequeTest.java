package deque;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {
    private class Max implements Comparator <Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return a - b; //for Integer type

        }
    }

    /**private class Min implements Comparator <Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a; //for Integer type

        }
    }
     **/
    Comparator compm = new Max();

    @Test
    public void Maxtest(){
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<> (compm);
        assertEquals(null, mad.max());

    }


}

