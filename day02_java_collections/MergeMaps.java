package day02_java_collections;

import java.util.*;

public class MergeMaps {
    public static void main(String[] args) {
        // First map
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        // Second map
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        // Display the merged map
        System.out.println("Merged Map: " + mergedMap);
    }

    // Method to merge two maps, summing values for common keys
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);  // Start with all entries from map1

        // Iterate through map2 and merge values
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            result.merge(entry.getKey(), entry.getValue(), Integer::sum);  // Sum values if key exists
        }

        return result;  // Return the merged map
    }
}
