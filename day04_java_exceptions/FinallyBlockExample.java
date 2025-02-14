package day04_java_exceptions;

import java.util.Scanner;

public class FinallyBlockExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            // Read the num1 as a int value
            System.out.print("Enter any number: ");
            int num1 =  sc.nextInt();

            // // Read the num2 as a int value
            System.out.print("Enter any number again: ");
            int num2 = sc.nextInt();

            int divideNum1ByNum2 = num1/num2; //This may throw ArithmeticException
            System.out.println("Division: "+num1+" / "+ num2 + " is "+divideNum1ByNum2);
        } catch (ArithmeticException e) {
            System.out.println("You can't divide by zero");
        } finally {
            //finally block always executes
            System.out.println("Operation completed");
        }
    }
}
