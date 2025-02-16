package day06_annotations_reflection;

import java.lang.reflect.Field;

public class ReflectionExample {

    public static void main(String[] args) {
        try {
            // Create an instance of the Person class
            Person person = new Person(25);

            // Get the Class object for the Person class
            Class<?> personClass = person.getClass();

            // Get the private field 'age'
            Field ageField = personClass.getDeclaredField("age");

            // Set the accessibility to true to access the private field
            ageField.setAccessible(true);

            // Retrieve the value of the 'age' field
            int age = (int) ageField.get(person);
            System.out.println("Initial age: " + age);

            // Modify the value of the 'age' field
            ageField.set(person, 30);

            // Retrieve the new value of the 'age' field
            age = (int) ageField.get(person);
            System.out.println("Modified age: " + age);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
