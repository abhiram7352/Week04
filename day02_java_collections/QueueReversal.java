package day02_java_collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueReversal {

    // Method to reverse the elements of a queue
    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return queue; // Base case: if the queue is empty, return it
        }
        int front = queue.remove(); // Remove the front element
        reverseQueue(queue); // Recursively reverse the remaining queue
        queue.add(front); // Add the removed element to the rear
        return queue; // Return the reversed queue
    }

    public static void main(String[] args) {
        // Create a queue and add elements
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        // Reverse the queue
        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}
