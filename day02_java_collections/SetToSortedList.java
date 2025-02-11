package day02_java_collections;

import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        // Step 1: Initialize the HashSet
        Set<Integer> hashSet = new LinkedHashSet<>();
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(9);
        hashSet.add(1);

        // Step 2: Convert HashSet to List
        List<Integer> sortedList = new ArrayList<>(hashSet);

        // Step 3: Sort the list in ascending order
        Collections.sort(sortedList);  // Alternatively, sortedList.sort(null);

        // Output the sorted list
        System.out.println("Original Set: " + hashSet);
        System.out.println("Sorted List: " + sortedList);
    }
}
