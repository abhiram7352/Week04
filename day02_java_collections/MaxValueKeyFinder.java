package day02_java_collections;

import java.util.*;

public class MaxValueKeyFinder {
    public static void main(String[] args) {
        // Original map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        // Find the key with the maximum value
        String maxKey = findKeyWithMaxValue(map);

        // Display the result
        System.out.println("Key with the highest value: " + maxKey);
    }

    // Method to find the key with the maximum value
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        if (map.isEmpty()) return null;  // Return null if map is empty

        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;  // Update maxEntry if current value is greater
            }
        }

        return maxEntry.getKey();  // Return the key with the maximum value
    }
}
