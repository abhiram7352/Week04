package day05_java_regex;

import java.util.regex.*;
import java.util.*;

public class LinkExtractor {
    public static List<String> extractLinks(String text) {
        // Regular expression to match URLs (http, https)
        String regex = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(\\S*)?\\b";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // List to store extracted links
        List<String> links = new ArrayList<>();

        // Find all matches
        while (matcher.find()) {
            links.add(matcher.group());
        }

        return links;
    }

    public static void main(String[] args) {
        // Example text containing links
        String text = "Visit https://www.google.com and http://example.org for more info.";

        // Extract links
        List<String> links = extractLinks(text);

        // Print extracted links
        System.out.println(String.join(", ", links));
    }
}
