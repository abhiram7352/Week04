package day05_java_regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHexColorCode {
    public static boolean isValidHexColorCode(String colorCode) {
        // Regular expression to validate hex color code
        String regex = "^#[a-zA-Z0-9]{6}$";

        // Compile the regex into a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object to check the input against the pattern
        Matcher matcher = pattern.matcher(colorCode);

        // Return whether the hex color code matches the regex pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter your hex color code: ");

        // Read the input hex color code from the user
        String hexColorCode = sc.nextLine();

        // Validate the hex color code and print the result
        System.out.println("Is your hex color code valid? " + isValidHexColorCode(hexColorCode));

    }
}


