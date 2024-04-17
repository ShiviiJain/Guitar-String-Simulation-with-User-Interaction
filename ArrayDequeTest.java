package deque;

import org.junit.Test;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

    /** Performs some basic linked list tests. */
    public class ArrayDequeTest{

        @Test
        /** Adds a few things to the list, checking isEmpty() and size() are correct,
         * finally printing the results.
         *
         * && is the "and" operation. */
        public void addIsEmptySizeTest() {
            ArrayDeque<String> array = new ArrayDeque<>();
            assertTrue("A newly initialized ArrayDeque should be empty", array.isEmpty());
            array.addFirst("front");
            // The && operator is the same as "and" in Python.
            // It's a binary operator that returns true if both arguments true, and false otherwise.
            assertEquals(1, array.size());
            assertFalse("array should now contain 1 item", array.isEmpty());
            array.addLast("middle");
            assertEquals(2, array.size());
            array.addLast("back");
            assertEquals(3, array.size());
            System.out.println("Printing out deque: ");
            array.printDeque();

        }

        @Test
        public void addresize() {
            ArrayDeque <Integer> ar3 = new ArrayDeque <>();
            for (int i = 0; i < 10; i++) {
                ar3.addFirst(i);
            }
            assertEquals("should have 10 items", 10, ar3.size());
        }
        @Test
        /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
        public void addRemoveTest() {

            ArrayDeque<Integer> ar2 = new ArrayDeque<Integer>();
            // should be empty
            assertTrue("ar2 should be empty upon initialization", ar2.isEmpty());

            ar2.addFirst(10);
            // should not be empty
            assertFalse("ar2 should contain 1 item", ar2.isEmpty());

            ar2.removeFirst();
            // should be empty
            assertTrue("ar2 should be empty after removal", ar2.isEmpty());

        }



        @Test
        /* Tests removing from an empty deque */
        public void removeEmptyTest() {


            ArrayDeque<Integer> ar6 = new ArrayDeque<>();
            ar6.addFirst(3);

            ar6.removeLast();
            ar6.removeFirst();
            ar6.removeLast();
            ar6.removeFirst();

            int size = ar6.size();
            String errorMsg = "  Bad size returned when removing from empty deque.\n";
            errorMsg += "  student size() returned " + size + "\n";
            errorMsg += "  actual size() returned 0\n";

            assertEquals(errorMsg, 0, size);

        }

        @Test
        /* Check if you can create LinkedListDeques with different parameterized types*/
        public void multipleParamTest() {
            LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
            LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
            LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();
            lld1.addFirst("string");
            lld2.addFirst(3.14159);
            lld3.addFirst(true);
            String s = lld1.removeFirst();
            double d = lld2.removeFirst();
            boolean b = lld3.removeFirst();
        }
        @Test
        /* check if null is return when removing from an empty LinkedListDeque. */
        public void emptyNullReturnTest() {
            ArrayDeque<Integer> pos = new ArrayDeque<Integer>();
            boolean passed1 = false;
            boolean passed2 = false;
            assertEquals("Should return null when removeFirst is called on an empty Deque,", null, pos.removeFirst());
            assertEquals("Should return null when removeLast is called on an empty Deque,", null, pos.removeLast());
        }

        @Test
        /* Add large number of elements to deque; check if order is correct. */
        public void bigArrayDequeTest() {


            ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
            for (int i = 0; i < 1000000; i++) {
                arr.addLast(i);
            }

            for (double i = 0; i < 500000; i++) {
                assertEquals("Should have the same value", i, (double) arr.removeFirst(), 0.0);
            }

            for (double i = 999999; i > 500000; i--) {
                assertEquals("Should have the same value", i, (double) arr.removeLast(), 0.0);
            }
        }

        @Test
        public void getTest(){
            ArrayDeque<Integer> art = new ArrayDeque<Integer>();
            assertEquals("expect null", null, art.get(0));
            art.addLast(5);
            assertEquals("expect 5", 5, (int)art.get(0));
            }



    }



