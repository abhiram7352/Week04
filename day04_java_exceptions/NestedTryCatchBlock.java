package day04_java_exceptions;

import java.util.Scanner;

public class NestedTryCatchBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int[] array = {3, 4, 5, 1, 6, 0};
            System.out.print("Enter index: ");
            int index = sc.nextInt();

            System.out.print("Enter divisor: ");
            int divisor = sc.nextInt();
            //Try to access the element
            int element = array[index] ;
            try {
               //Nested try-catch block to handle division by zero
                System.out.println("Result: " + array[index] + " / " + divisor + " is " + element/divisor);
            } catch (ArithmeticException e) {

                //Handle division by zero
                System.out.println("Cannot divide by zero!");

            }
        }catch ( ArrayIndexOutOfBoundsException e){

            //Handle invalid index
                System.out.println("Invalid array index!");
        }
    }
}
