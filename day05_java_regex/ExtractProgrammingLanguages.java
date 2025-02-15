package day05_java_regex;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class ExtractProgrammingLanguages {
    public static List<String> extractLanguages(String text) {
        // Define regex pattern to match programming languages (case-sensitive)
        String regex = "\\b(JavaScript|Java|Python|Go|C\\+\\+|C|C#|Ruby|Swift|Kotlin|PHP|TypeScript|Rust|Perl)\\b";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // List to store matched programming languages
        List<String> languages = new ArrayList<>();

        // Find all matches
        while (matcher.find()) {
            languages.add(matcher.group());
        }

        return languages;
    }

    public static void main(String[] args) {
        // Example input text
        String input = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Extract and print programming languages
        List<String> output = extractLanguages(input);
        System.out.println(output);
    }
}
