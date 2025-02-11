package day02_java_collections;

import java.util.LinkedList;
import java.util.Queue;

// Class to implement Stack using two Queues
public class StackUsingQueues {
    private Queue<Integer> mainQueue;   // Queue that holds the stack elements
    private Queue<Integer> helperQueue; // Temporary queue to assist in push operation

    // Constructor to initialize queues
    public StackUsingQueues() {
        mainQueue = new LinkedList<>();
        helperQueue = new LinkedList<>();
    }

    // Push operation: Add element to the top of the stack
    public void push(int x) {
        // Step 1: Add the new element to the helper queue
        helperQueue.add(x);

        // Step 2: Move all elements from mainQueue to helperQueue
        while (!mainQueue.isEmpty()) {
            helperQueue.add(mainQueue.remove());
        }

        // Step 3: Swap the names of mainQueue and helperQueue
        Queue<Integer> temp = mainQueue;
        mainQueue = helperQueue;
        helperQueue = temp;
    }

    // Pop operation: Remove and return the top element of the stack
    public int pop() {
        if (mainQueue.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return mainQueue.remove();
    }

    // Top operation: Return the top element of the stack without removing it
    public int top() {
        if (mainQueue.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return mainQueue.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return mainQueue.isEmpty();
    }

    // Main method to test the StackUsingQueues implementation
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Output: 3

        // Pop the top element
        System.out.println("Popped element: " + stack.pop()); // Output: 3

        // Check the new top element
        System.out.println("Top element after pop: " + stack.top()); // Output: 2

        // Push another element
        stack.push(4);
        System.out.println("Top element after pushing 4: " + stack.top()); // Output: 4
    }
}
