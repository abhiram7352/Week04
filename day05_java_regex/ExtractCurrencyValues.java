package day05_java_regex;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class ExtractCurrencyValues {
    public static List<String> extractCurrencies(String text) {
        // Define regex pattern to match currency values (with or without $ symbol)
        String regex = "\\$?\\d+\\.\\d{2}";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // List to store matched currency values
        List<String> currencies = new ArrayList<>();

        // Find all matches
        while (matcher.find()) {
            currencies.add(matcher.group());
        }

        return currencies;
    }

    public static void main(String[] args) {
        // Example input text
        String input = "The price is $45.99, and the discount is 10.50.";

        // Extract and print currency values
        List<String> output = extractCurrencies(input);
        System.out.println(output);
    }
}
