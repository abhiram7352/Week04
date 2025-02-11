package day02_java_collections;

import java.util.Set;
import java.util.HashSet;

public class SymmetricDifference {
    public static void main(String[] args) {
        // Initialize Set1 and Set2
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Step 1: Union of set1 and set2
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);

        // Step 2: Intersection of set1 and set2
        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);

        // Step 3: Symmetric Difference = Union - Intersection
        unionSet.removeAll(intersectionSet);

        // Output the symmetric difference
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Symmetric Difference: " + unionSet);
    }
}
