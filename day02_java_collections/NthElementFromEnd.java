package day02_java_collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class NthElementFromEnd {
    //Method to find nth from the end
    public static <T> T findNthFromEnd(LinkedList<T> list, int N) {
        if (list == null || N <= 0) {
            throw new IllegalArgumentException("Invalid list or N value");
        }

        // Initialize two iterators
        ListIterator<T> first = list.listIterator();
        ListIterator<T> second = list.listIterator();

        // Move the first iterator N steps ahead
        for (int i = 0; i < N; i++) {
            if (!first.hasNext()) {
                throw new IllegalArgumentException("N is larger than the size of the list");
            }
            first.next();
        }

        // Move both iterators until the first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        // The second iterator is now at the Nth element from the end
        return second.next();
    }

    //Main method
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2;
        try {
            String result = findNthFromEnd(list, N);
            System.out.println("The " + N + "th element from the end is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
