package day06_annotations_reflection;

import java.lang.annotation.Annotation;

public class AnnotationExample {

    public static void main(String[] args) {
        try {
            // Get the Class object for the Book class
            Class<?> bookClass = Class.forName("day06_annotations_reflection.Book");

            // Check if the class has the Author annotation
            if (bookClass.isAnnotationPresent(Author.class)) {
                // Get the Author annotation
                Annotation annotation = bookClass.getAnnotation(Author.class);
                Author author = (Author) annotation;

                // Display the annotation value
                System.out.println("Author: " + author.name());
            } else {
                System.out.println("Author annotation not present");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
