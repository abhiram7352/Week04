package day02_java_collections;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        // Specify the path to the input text file
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\Java Full Stack Training\\Week04\\src\\main\\java\\day02_java_collections\\InsurancePolicyManagementSystem.java\\";  // Make sure the file exists in the project directory

        // HashMap to store word frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read the file line by line
            while ((line = br.readLine()) != null) {
                // Convert the line to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");

                // Split the line into words based on spaces
                String[] words = line.split("\\s+");

                // Update the word frequencies in the HashMap
                for (String word : words) {
                    if (!word.isEmpty()) {  // Ignore empty strings
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        // Display the word frequencies
        System.out.println("--- Word Frequencies ---");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
