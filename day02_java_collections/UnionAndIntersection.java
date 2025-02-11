package day02_java_collections;


import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection {
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

        // Compute Union
        Set<Integer> unionSet = new HashSet<>(set1);  // Create a copy of set1
        unionSet.addAll(set2);  // Add all elements from set2

        // Compute Intersection
        Set<Integer> intersectionSet = new HashSet<>(set1);  // Create a copy of set1
        intersectionSet.retainAll(set2);  // Retain only common elements

        // Output the results
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Union: " + unionSet);
        System.out.println("Intersection: " + intersectionSet);
    }
}

