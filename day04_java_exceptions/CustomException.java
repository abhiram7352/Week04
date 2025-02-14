package day04_java_exceptions;

// Custom Exception class that extends Exception
class InvalidAgeException extends Exception {
    // Constructor to initialize the exception message
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void main(String[] args) {
        try {
            // Calling the validateAge method with 18 as input
            validateAge(18);
        } catch (InvalidAgeException e) {
            // Catching and handling the custom exception
            System.out.println("Caught custom exception: 'InvalidAgeException': " + e.getMessage());
        }
    }

    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throwing custom exception if age is less than 18
            throw new InvalidAgeException("Age must be 18 or older");
        } else {
            // Age is valid, granting access
            System.out.println("Access granted");
        }
    }
}
