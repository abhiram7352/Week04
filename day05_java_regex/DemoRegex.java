package day05_java_regex;
import java.util.regex.*;
public class DemoRegex {
    public static void main(String[] args) {
            // Define the regex pattern
            String regex = "\\d{3}";  // Matches exactly 3 digits
            Pattern pattern = Pattern.compile(regex);
            // Input string to check
            String input = "The number is 123 and code is 456.";

            // Create matcher object
            Matcher matcher = pattern.matcher(input);
            // Find matches
            while (matcher.find()) {
                System.out.println("Matched: " + matcher.group());
            }
        }
    }


