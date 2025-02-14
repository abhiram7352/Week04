package day04_java_exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Try to catch exceptions
        try{
            System.out.print("Enter any number1: ");
            int num1 = sc.nextInt();
            System.out.print("Enter any number2: ");
            int num2 = sc.nextInt();
            int result = num1/num2; // This may throw arithmetic exception
        } catch (ArithmeticException e) {
            // Handle the exception if the divide by 0;
            System.out.println("ArithmeticException caught: " + e.getMessage());

        } catch (InputMismatchException e){
            // Handle the exception if the input is not integer or any InputMismatchException occurs
            System.out.println("InputMismatchException caught: " + e.getMessage());

        }
    }
}
