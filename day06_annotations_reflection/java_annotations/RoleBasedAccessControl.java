package day06_annotations_reflection.java_annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Main class
public class RoleBasedAccessControl {

    // Define the custom annotation @RoleAllowed
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface RoleAllowed {
        String value();
    }

    // Class with annotated methods
    public static class TaskManager {

        @RoleAllowed("ADMIN")
        public void adminTask() {
            System.out.println("Executing admin task");
        }

        @RoleAllowed("USER")
        public void userTask() {
            System.out.println("Executing user task");
        }

        public void commonTask() {
            System.out.println("Executing common task");
        }
    }

    // Method to simulate user roles and validate access
    public static void executeMethod(Object obj, Method method, String userRole) {
        try {
            // Check if the method has the RoleAllowed annotation
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (roleAllowed.value().equals(userRole)) {
                    // User has the required role, invoke the method
                    method.invoke(obj);
                } else {
                    // User does not have the required role, print access denied
                    System.out.println("Access Denied! User does not have the required role: " + roleAllowed.value());
                }
            } else {
                // Method does not have role restrictions, invoke the method
                method.invoke(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main method to test the role-based access control
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Simulate user roles
        String adminRole = "ADMIN";
        String userRole = "USER";

        // Get the Class object for the TaskManager class
        Class<?> taskManagerClass = TaskManager.class;

        // Iterate through all methods of the class and simulate method execution
        for (Method method : taskManagerClass.getDeclaredMethods()) {
            System.out.println("Executing method as ADMIN:");
            executeMethod(taskManager, method, adminRole);
            System.out.println();

            System.out.println("Executing method as USER:");
            executeMethod(taskManager, method, userRole);
            System.out.println();
        }
    }
}
