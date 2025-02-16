package day06_annotations_reflection;

import java.lang.reflect.Method;

public class SampleClassMethodTimer  {

    public static void measureExecutionTime(Object obj, String methodName, Class<?>... parameterTypes) {
        try {
            // Get the Class object for the given object's class
            Class<?> clazz = obj.getClass();

            // Get the method by name and parameter types
            Method method = clazz.getMethod(methodName, parameterTypes);

            // Record the start time
            long startTime = System.nanoTime();

            // Invoke the method
            method.invoke(obj);

            // Record the end time
            long endTime = System.nanoTime();

            // Calculate and display the execution time
            long duration = endTime - startTime;
            System.out.println("Execution time of " + methodName + ": " + duration + " nanoseconds");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
