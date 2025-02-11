package day02_java_collections;

import java.net.Inet4Address;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        Set<Integer> ans = new LinkedHashSet<>(list);

        //Displaying result
        System.out.println("Original List: "+list);
        System.out.println("Unique list: "+ans);
    }
}
