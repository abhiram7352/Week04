package day02_java_collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateElement {
    public static void main(String[] args) {
        // Create a list using the List interface
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        System.out.println("Original List: " + list);
        Collections.rotate(list, rotateBy); // Rotate the list
        System.out.println("Rotated List: " + list);
    }
}
