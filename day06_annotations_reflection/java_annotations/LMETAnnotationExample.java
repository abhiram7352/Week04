package day06_annotations_reflection.java_annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

    // Main class
    public class LMETAnnotationExample {

        // Define the custom annotation @Todo
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        public @interface Todo {
            String task();
            String assignedTo();
            String priority() default "MEDIUM";
        }

        // Class with annotated methods
        public static class Project {

            @Todo(task = "Implement user login", assignedTo = "Alice", priority = "HIGH")
            public void userLogin() {
                // Method implementation
                System.out.println("User login feature");
            }

            @Todo(task = "Create database schema", assignedTo = "Bob")
            public void createDatabase() {
                // Method implementation
                System.out.println("Database schema feature");
            }

            @Todo(task = "Set up CI/CD pipeline", assignedTo = "Charlie", priority = "LOW")
            public void setupCICD() {
                // Method implementation
                System.out.println("CI/CD pipeline feature");
            }
        }

        // Main method to retrieve and display the annotation details
        public static void main(String[] args) {
            try {
                // Get the Class object for the Project class
                Class<?> projectClass = Project.class;

                // Iterate through all methods of the class
                for (Method method : projectClass.getDeclaredMethods()) {
                    // Check if the method has the Todo annotation
                    if (method.isAnnotationPresent(Todo.class)) {
                        // Get the Todo annotation
                        Todo todo = method.getAnnotation(Todo.class);

                        // Display the annotation details
                        System.out.println("Method: " + method.getName());
                        System.out.println("Task: " + todo.task());
                        System.out.println("Assigned To: " + todo.assignedTo());
                        System.out.println("Priority: " + todo.priority());
                        System.out.println();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

