package day06_annotations_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassInfo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();

        try {
            // Load the class
            Class<?> cls = Class.forName(className);

            // Display class name
            System.out.println("Class Name: " + cls.getName());

            // Display constructors
            System.out.println("Constructors:");
            Constructor<?>[] constructors = cls.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Display methods
            System.out.println("Methods:");
            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            // Display fields
            System.out.println("Fields:");
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
