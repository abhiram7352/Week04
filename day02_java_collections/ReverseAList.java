package day02_java_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReverseAList {

    //Method name reverseAListUsingList to reverse the list input
    static List<Integer> reverseAListUsingList(List<Integer> ls){
        List<Integer> res = new ArrayList<>();
        for(int i=ls.size()-1; i>=0; i--){
            res.add(ls.get(i));
        }
        return res;

    }
    //Method name reverseAListUsingLinedList to reverse the list input
    static List<Integer> reverseAListUsingLinedList(List<Integer> ls){
        LinkedList<Integer> res = new LinkedList<>();
        for(int i= ls.size()-1; i>=0; i--){
            res.add(ls.get(i));
        }
        return res;
    }

    //Main method
    public static void main(String[] args) {

        //Declarization and Initialization of the list
        List<Integer> ls = Arrays.asList(1,2,3,4,5);

        //Displaying the output using both method respectively
        System.out.println("Reversed list using ArrayList: " +reverseAListUsingList(ls));
        System.out.println("-----------------------------------------------");
        System.out.println("Reversed list using LinkedList: "+reverseAListUsingLinedList(ls));
    }
}
