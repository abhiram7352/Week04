package day05_java_regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLicense {
    public static boolean isValidLicenseNumber(String licenseNumber) {
        // Regular expression to validate license plate number
        String regex = "^[A-Z]{2}[0-9]{4}$";

        // Compile the regex into a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object to check the input against the pattern
        Matcher matcher = pattern.matcher(licenseNumber);

        // Return whether the licenseNumber matches the regex pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter your license plate number: ");

        // Read the input username's license number from the user
        String licenseNumber = sc.nextLine();

        // Validate the license plate number and print the result
        System.out.println("Is your license plate number valid? " + isValidLicenseNumber(licenseNumber));

    }
}


