package day05_java_regex.junit;

import java.util.List;

public class ListManager {
    //Adds an element to a list
    public static void addElement(List<Integer> list, int element){
        list.add(element);
    }
    //removes an element from a list
    public static boolean removeElement(List<Integer> list, int element){
        return list.remove(Integer.valueOf(element));
    }
    //return the size of the list
    public static int getSize(List<Integer> list){
        return list.size();
    }
}
