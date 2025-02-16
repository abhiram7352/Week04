package day06_annotations_reflection.java_annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {

    // Define the custom annotation @TaskInfo
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TaskInfo {
        int priority();
        String assignedTo();
    }

    // TaskManager class with annotated methods
    public static class TaskManager {

        @TaskInfo(priority = 1, assignedTo = "Alice")
        public void taskA() {
            System.out.println("Executing Task A");
        }

        @TaskInfo(priority = 2, assignedTo = "Bob")
        public void taskB() {
            System.out.println("Executing Task B");
        }
    }

    // Main method to retrieve and display the annotation details
    public static void main(String[] args) {
        try {
            // Get the Class object for the TaskManager class
            Class<?> taskManagerClass = TaskManager.class;

            // Iterate through all methods of the class
            for (Method method : taskManagerClass.getDeclaredMethods()) {
                // Check if the method has the TaskInfo annotation
                if (method.isAnnotationPresent(TaskInfo.class)) {
                    // Get the TaskInfo annotation
                    TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                    // Display the annotation details
                    System.out.println("Method: " + method.getName());
                    System.out.println("Priority: " + taskInfo.priority());
                    System.out.println("Assigned To: " + taskInfo.assignedTo());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
