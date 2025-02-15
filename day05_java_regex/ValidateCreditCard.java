package day05_java_regex;

import java.util.regex.*;

public class ValidateCreditCard {
    public static boolean isValidCreditCard(String cardNumber) {
        // Regular expression for Visa (16 digits, starts with 4) or MasterCard (16 digits, starts with 5)
        String regex = "^(4[0-9]{15}|5[0-9]{15})$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);

        // Return whether the card number matches the pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Example credit card numbers
        String[] testCards = {
                "4111111111111111", // Valid Visa
                "5105105105105100", // Valid MasterCard
                "1234567812345678", // Invalid (does not start with 4 or 5)
                "411111111111111",  // Invalid (only 15 digits)
                "51111111111111111" // Invalid (17 digits)
        };

        // Validate each credit card number
        for (String card : testCards) {
            System.out.println(card + " is valid? " + isValidCreditCard(card));
        }
    }
}
