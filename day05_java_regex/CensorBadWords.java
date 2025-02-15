package day05_java_regex;

import java.util.regex.*;

public class CensorBadWords {
    public static String censorText(String text, String[] badWords) {
        // Create regex pattern to match bad words (case-insensitive)
        String regex = String.join("|", badWords);
        Pattern pattern = Pattern.compile("\\b(" + regex + ")\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        // Replace bad words with ****
        return matcher.replaceAll("****");
    }

    public static void main(String[] args) {
        // Example input
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};  // List of bad words

        // Process and print output
        String output = censorText(input, badWords);
        System.out.println(input);
        System.out.println();
        System.out.println(output);
    }
}
