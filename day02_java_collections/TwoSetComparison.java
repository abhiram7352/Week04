package day02_java_collections;

import java.util.HashSet;
import java.util.Set;
public class TwoSetComparison {
        public static void main(String[] args) {
            Set<Integer> set1 = new HashSet<>();
            set1.add(1);
            set1.add(2);
            set1.add(3);

            Set<Integer> set2 = new HashSet<>();
            set2.add(3);
            set2.add(2);
            set2.add(1);

            // Using equals() to check if sets are equal
            boolean areEqual = set1.equals(set2);

            //Displaying results
            System.out.println("Are sets equal? " + areEqual);
        }
    }
