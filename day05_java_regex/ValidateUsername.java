package day05_java_regex; // Package declaration

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUsername { // Class definition

    public static boolean isValidUsername(String username) {
        // Regular expression to validate the username
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        // Compile the regex into a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object to check the input against the pattern
        Matcher matcher = pattern.matcher(username);

        // Return whether the username matches the regex pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter your user name: ");

        // Read the input username from the user
        String username = sc.nextLine();

        // Validate the username and print the result
        System.out.println("Is your username valid? " + isValidUsername(username));

    }
}
