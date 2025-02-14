package day04_java_exceptions;

import java.util.Scanner;

public class Method1VSMethod2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            // Read the num1 as a int value
            System.out.print("Enter any number: ");
            int num1 = sc.nextInt();
            // // Read the num2 as a int value
            System.out.print("Enter any number again: ");
            int num2 = sc.nextInt();

            try {
                //This may throw ArithmeticException
                System.out.println("Division: " + num1 + " / " + num2 + " is " + method2(num1, num2));
            } catch (ArithmeticException e) {
                //Handled exception
                System.out.println("Handled exception in main");
            }
        }
        //method1 may throw ArithmeticException
            private static int method1(int num1,  int num2){
                if(num2<0)
                    throw new ArithmeticException();
                return num1/num2;
            }
            //method1 calls method1
            public static int method2(int num1,  int num2){
                int ans = method1(num1, num2);
                return ans;
            }

        }



