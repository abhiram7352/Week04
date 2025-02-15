package day05_java_regex;

import java.util.regex.*;

public class ReplaceMultipleSpaces {
    public static String removeExtraSpaces(String text) {
        // Define regex pattern for multiple spaces
        String regex = "\\s+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Replace multiple spaces with a single space
        return matcher.replaceAll(" ").trim();
    }

    public static void main(String[] args) {
        // Example input
        String input = "This   is  an   example   with  multiple    spaces.";

        // Process and print output
        String output = removeExtraSpaces(input);
        System.out.println(output);
    }
}
