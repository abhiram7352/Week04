package day05_java_regex;

import java.util.regex.*;

public class ValidateSSN {
    public static boolean isValidSSN(String ssn) {
        // Regular expression for SSN in the format "XXX-XX-XXXX"
        String regex = "^(\\d{3}-\\d{2}-\\d{4})$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);

        // Return whether the SSN matches the pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Example SSN inputs
        String[] testSSNs = {
                "123-45-6789", // Valid
                "123456789",   // Invalid (missing dashes)
                "12-345-6789", // Invalid (wrong format)
                "123-4-6789"   // Invalid (wrong format)
        };

        // Validate each SSN
        for (String ssn : testSSNs) {
            System.out.println(ssn + " is valid? " + isValidSSN(ssn));
        }
    }
}
