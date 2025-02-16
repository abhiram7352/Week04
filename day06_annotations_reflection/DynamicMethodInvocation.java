package day06_annotations_reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodInvocation {

    public static void main(String[] args) {
        try {
            // Create an instance of the MathOperations class
            MathOperations mathOps = new MathOperations();

            // Get the Class object for the MathOperations class
            Class<?> mathOpsClass = mathOps.getClass();

            // Get user input for the method name
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            // Get the method based on the user input
            Method method = mathOpsClass.getMethod(methodName, int.class, int.class);

            // Get user input for the method arguments
            System.out.print("Enter first number: ");
            int a = scanner.nextInt();
            System.out.print("Enter second number: ");
            int b = scanner.nextInt();

            // Invoke the method with the provided arguments
            int result = (int) method.invoke(mathOps, a, b);
            System.out.println("Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
