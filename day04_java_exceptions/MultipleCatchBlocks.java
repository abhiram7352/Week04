package day04_java_exceptions;

import java.util.Scanner;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ar ={1,2,4,99,5,6,1};

        try{
            // Accepting index input from user
            System.out.print("Enter any index: ");
            int index = sc.nextInt();
            int Y = ar[index];

            // Retrieving and printing value at the given index
            System.out.println("Value at index "+ index+": " + Y);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handling invalid index error
            System.out.println("Invalid index!" + e.getMessage());
        } catch (NullPointerException e) {
            // Handling null array error
            System.out.println("Array is not initialized!" + e.getMessage());
        }
    }
}
