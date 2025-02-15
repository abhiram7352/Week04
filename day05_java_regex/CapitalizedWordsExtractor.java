package day05_java_regex;

import java.util.*;
import java.util.regex.*;

public class CapitalizedWordsExtractor {
    public static List<String> extractCapitalizedWords(String sentence) {
        List<String> capitalizedWords = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b"); // Matches capitalized words
        Matcher matcher = pattern.matcher(sentence);

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        return capitalizedWords;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> result = extractCapitalizedWords(text);
        System.out.println(result); // Output: [Eiffel, Tower, Paris, Statue, Liberty, New, York]
    }
}
