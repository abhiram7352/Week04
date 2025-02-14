package day04_java_exceptions;

import java.util.Scanner;

public class ThrowVsThrows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Read the amount as a double value
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            // Read the rate as a double value
            System.out.print("Enter rate: ");
            double rate = sc.nextDouble();

            // Read the number of years as an integer
            System.out.print("Enter years: ");
            int years = sc.nextInt();

            // Calculate and print the simple interest
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Simple Interest: " + interest);
        } catch (IllegalArgumentException e) {
            // Handle invalid input by displaying an error message
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }

    // Method to calculate simple interest

    private static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount <= 0 || rate < 0) { // Check if amount or rate is negative
            throw new IllegalArgumentException(); // Throw exception if negative
        }
        return (amount * rate * years) / 100.0;
    }
}