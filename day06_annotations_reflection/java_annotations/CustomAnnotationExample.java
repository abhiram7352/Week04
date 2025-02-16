package day06_annotations_reflection.java_annotations;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

    // Main class
    public class CustomAnnotationExample {

        // Define the custom annotation @ImportantMethod
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        public @interface ImportantMethod {
            String level() default "HIGH";
        }

        // Class with annotated methods
        public static class TaskManager {

            @ImportantMethod
            public void criticalTask() {
                System.out.println("Executing critical task");
            }

            @ImportantMethod(level = "MEDIUM")
            public void importantTask() {
                System.out.println("Executing important task");
            }

            public void regularTask() {
                System.out.println("Executing regular task");
            }
        }

        // Main method to retrieve and display the annotation details
        public static void main(String[] args) {
            try {
                // Get the Class object for the TaskManager class
                Class<?> taskManagerClass = TaskManager.class;

                // Iterate through all methods of the class
                for (Method method : taskManagerClass.getDeclaredMethods()) {
                    // Check if the method has the ImportantMethod annotation
                    if (method.isAnnotationPresent(ImportantMethod.class)) {
                        // Get the ImportantMethod annotation
                        ImportantMethod importantMethod = method.getAnnotation(ImportantMethod.class);

                        // Display the annotation details
                        System.out.println("Method: " + method.getName());
                        System.out.println("Importance Level: " + importantMethod.level());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

