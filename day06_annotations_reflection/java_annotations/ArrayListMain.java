package day06_annotations_reflection.java_annotations;

import java.util.ArrayList;

public class ArrayListMain {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Create an ArrayList without generics
        ArrayList rawList = new ArrayList();

        // Add elements to the raw list
        rawList.add("Hello");
        rawList.add(123);

        // Retrieve and print elements from the raw list
        String str = (String) rawList.get(0);
        int num = (int) rawList.get(1);

        System.out.println("String: " + str);
        System.out.println("Number: " + num);
    }
}
