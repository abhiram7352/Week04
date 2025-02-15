package day05_java_regex;

import java.util.*;
import java.util.regex.*;

public class FindRepeatingWords {
    public static Set<String> findRepeatingWords(String text) {
        // Define regex pattern to match consecutive repeating words
        String regex = "\\b(\\w+)\\b(?:\\s+\\1\\b)+";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        // Set to store repeating words (ensures uniqueness)
        Set<String> repeatingWords = new HashSet<>();

        // Find all matches
        while (matcher.find()) {
            repeatingWords.add(matcher.group(1)); // Capture the repeated word
        }

        return repeatingWords;
    }

    public static void main(String[] args) {
        // Example input text
        String input = "This is is a repeated repeated word test.";

        // Extract and print repeating words
        Set<String> output = findRepeatingWords(input);
        System.out.println(output);
    }
}
