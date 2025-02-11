package day02_java_collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FrequencyOfElements {
    
    public static void main(String[] args) {
        //Created a fruits named List
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");

        //Createda wordCount named HashMap to sort key-value pairs
        HashMap<String,Integer> wordCount = new HashMap<>();

        //Interating over a list to get the count
        for(String word : fruits){
            wordCount.put(word, wordCount.getOrDefault(word,0)+1);
        }
        //Displaying the count;
        System.out.println(wordCount);
    }
}
