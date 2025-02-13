package day03_java_streams;

import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\JAVA\\Abstract_buffered.java"; // Path to the text file

        // Use a HashMap to count word occurrences
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Try-with-resources to ensure the BufferedReader is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase(); // Convert to lowercase for case-insensitive counting
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort the words based on frequency
        List<Map.Entry<String, Integer>> sortedWordList = new ArrayList<>(wordCountMap.entrySet());
        sortedWordList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Display the top 5 most frequently occurring words
        System.out.println("Top 5 most frequently occurring words:");
        for (int i = 0; i < Math.min(5, sortedWordList.size()); i++) {
            Map.Entry<String, Integer> entry = sortedWordList.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}