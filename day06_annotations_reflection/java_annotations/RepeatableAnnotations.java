package day06_annotations_reflection.java_annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RepeatableAnnotations {

        // Define the custom annotation @BugReport
        @Repeatable(BugReports.class)
        @Retention(RetentionPolicy.RUNTIME)
        public @interface BugReport {
            String description();
        }

        // Define the container annotation @BugReports
        @Retention(RetentionPolicy.RUNTIME)
        public @interface BugReports {
            BugReport[] value();
        }

        // TaskManager class with annotated methods
        public static class TaskManager {

            @BugReport(description = "Null pointer exception when task name is null")
            @BugReport(description = "Array index out of bounds when list is empty")
            public void executeTask() {
                // Method implementation
                System.out.println("Executing task");
            }
        }

        // Main method to retrieve and display the annotation details
        public static void main(String[] args) {
            try {
                // Get the Class object for the TaskManager class
                Class<?> taskManagerClass = TaskManager.class;

                // Get the executeTask method
                Method method = taskManagerClass.getMethod("executeTask");

                // Check if the method has the BugReports annotation
                if (method.isAnnotationPresent(BugReports.class)) {
                    // Get the BugReports annotation
                    BugReports bugReports = method.getAnnotation(BugReports.class);

                    // Display all bug reports
                    for (BugReport bugReport : bugReports.value()) {
                        System.out.println("Bug Report: " + bugReport.description());
                    }
                } else if (method.isAnnotationPresent(BugReport.class)) {
                    // Get single BugReport annotation
                    BugReport bugReport = method.getAnnotation(BugReport.class);
                    System.out.println("Bug Report: " + bugReport.description());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

