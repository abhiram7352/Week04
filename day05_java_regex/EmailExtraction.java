package day05_java_regex;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtraction {
    public static List<String> extractCapitalizedWords(String text) {
        // Regular expression to match capitalized words
        String regex = "\\b[A-Z][a-z]*\\b";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // List to store extracted capitalized words
        List<String> capitalizedWords = new ArrayList<>();

        // Find all matches
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        return capitalizedWords;
    }

    public static void main(String[] args) {
        // Example text
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Extract capitalized words
        List<String> capitalizedWords = extractCapitalizedWords(text);

        // Print extracted words
        System.out.println(String.join(", ", capitalizedWords));
    }
}