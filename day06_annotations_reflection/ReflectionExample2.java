package day06_annotations_reflection;

import java.lang.reflect.Method;

public class ReflectionExample2 {

    public static void main(String[] args) {
        try {
            // Create an instance of the Calculator class
            Calculator calculator = new Calculator();

            // Get the Class object for the Calculator class
            Class<?> calculatorClass = calculator.getClass();

            // Get the private method 'multiply'
            Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply", int.class, int.class);

            // Set the accessibility to true to access the private method
            multiplyMethod.setAccessible(true);

            // Invoke the private method with arguments
            int result = (int) multiplyMethod.invoke(calculator, 5, 3);
            System.out.println("Result of multiplication: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
