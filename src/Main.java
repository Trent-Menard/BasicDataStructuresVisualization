import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        final int CAPACITY = 20;

/*      My original plan was a "Walmart" recreation w/ objects such as Person,
        Store, Customer, Employee, but after a bit of brainstorming an easier
        "visual" representation is that of Integers b/c of their ordinality.
        I.e.: There's no need to memorize element location (index) before/after
        insertion/deletion b/c of Integer's natural ordering (assuming ascending).*/

/*      Array: The most basic data structure; stores memory contiguously.
        Index based allows for quick direct access. O(n).
        Not scalable though. Size must be initially declared.*/
        Integer[] arrayDS = new Integer[CAPACITY];

/*      LinkedList: A list that "points to" or is "linked" to another List.
        More scalable b/c size doesn't have to be declared initially but
        loose direct access to elements. Can expand/contract easily O(n).
        (Note: 'List' is an interface, NOT a class. LinkedList<> defines
        the type of class/object. LinkedList CAN be used in place of
        'List' but using it allows easier code integration, should the data structure need changing)*/
        List<Integer> listDS = new LinkedList<>();

/*      Dequeue, short for double ended queue, is an interface
        that allows insertion/removal at both ends.
        I.e.: it can act as either a Stack or Queue.*/

/*      Queue: A First-In-First-Out sequence of data elements.
        Items can only be removed from the front (dequeue) and added to the back (enqueue).*/
        Deque<Integer> stackDS = new ArrayDeque<>();

/*      Stack: A Last-In-First-Out sequence of data elements.
        Items can only be added to the top and removed from the top.*/
        Deque<Integer> queueDS = new ArrayDeque<>();

        // Fill each data structure w/ vales from 1 to 10 then print values
        for (int i = 0; i < CAPACITY; i++) {
            arrayDS[i] = i + 1;
            listDS.add(i + 1);
            stackDS.addFirst(i + 1); // Equivalent to push
            queueDS.addLast(i + 1); // Equivalent to enqueue
        }

        System.out.println("Initial Data Structures:");
        System.out.println("Array: \t" + Arrays.toString(arrayDS)); // Specify print array as a whole
        System.out.println("List: \t" + listDS);
        System.out.println("Queue: \t" + queueDS);
        System.out.println("Stack: \t" + stackDS);

        // Periodically (every 2s) removes 1 element from Stack & Queue resulting in half of the original.
        // Used for visual comparison (notice Stack is ascending & Queue is descending)
        for (int i = 0; i < CAPACITY / 2; i++){
            System.out.println("\nRemoving 1 item from Stack & Queue.");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Array & List are index based so N/A (would have to specify removal index)
            stackDS.removeFirst(); // Equivalent to pop
            queueDS.removeFirst(); // Equivalent to dequeue
            System.out.println("Queue: \t" + queueDS + "\t");
            System.out.println("Stack: \t" + stackDS + "\t");
        }
    }
}