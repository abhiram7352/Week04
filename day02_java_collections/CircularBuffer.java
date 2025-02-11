package day02_java_collections;

public class CircularBuffer {
    private int[] buffer;    // Array to hold the elements of the buffer
    private int head;        // Points to the oldest element
    private int tail;        // Points to the next insertion position
    private int size;        // Current number of elements in the buffer
    private int capacity;    // Maximum capacity of the buffer

    // Constructor to initialize the circular buffer with a fixed size
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    // Method to insert an element into the buffer
    public void insert(int value) {
        buffer[tail] = value;  // Insert the value at the tail position
        tail = (tail + 1) % capacity;  // Move tail to the next position (wrap-around if needed)

        if (size == capacity) {
            // If buffer is full, move head to the next position to overwrite the oldest element
            head = (head + 1) % capacity;
        } else {
            size++;  // Increase size if buffer is not full
        }
    }

    // Method to display the contents of the buffer
    public void displayBuffer() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;  // Calculate index considering wrap-around
            System.out.print(buffer[index]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Main method to demonstrate circular buffer operations
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);  // Create a buffer of size 3

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.displayBuffer();  // Output: [1, 2, 3]

        cb.insert(4);  // Overwrites the oldest element (1)
        cb.displayBuffer();  // Output: [2, 3, 4]

        cb.insert(5);  // Overwrites the next oldest element (2)
        cb.displayBuffer();  // Output: [3, 4, 5]

        cb.insert(6);
        cb.displayBuffer();  // Output: [4, 5, 6]
    }
}
