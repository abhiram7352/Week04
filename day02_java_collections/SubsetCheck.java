package day02_java_collections;

import java.util.Set;
import java.util.HashSet;

public class SubsetCheck {
    public static void main(String[] args) {
        // Initialize Set1 and Set2
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Check if Set1 is a subset of Set2
        boolean isSubset = set2.containsAll(set1);

        // Output the result
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Is Set1 a subset of Set2? " + isSubset);
    }
}
