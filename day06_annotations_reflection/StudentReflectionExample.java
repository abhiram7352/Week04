package day06_annotations_reflection;

import java.lang.reflect.Constructor;

public class StudentReflectionExample {

    public static void main(String[] args) {
        try {
            // Get the Class object for the Student class using fully qualified name
            Class<?> studentClass = Class.forName("day06_annotations_reflection.Student");

            // Get the default constructor
            Constructor<?> constructor = studentClass.getConstructor();

            // Create a new instance using the constructor
            Object studentInstance = constructor.newInstance();

            // Display the created instance
            System.out.println(studentInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
