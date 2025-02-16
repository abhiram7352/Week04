package day06_annotations_reflection.java_annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

    // Main class
    public class MaxLengthMain {

        // Define the custom annotation @MaxLength
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        public @interface MaxLength {
            int value();
        }

        // User class with annotated field
        public static class User {
            @MaxLength(10)
            private String username;

            // Constructor with validation
            public User(String username) {
                // Validate the length of the username field
                try {
                    Field field = this.getClass().getDeclaredField("username");
                    if (field.isAnnotationPresent(MaxLength.class)) {
                        MaxLength maxLength = field.getAnnotation(MaxLength.class);
                        if (username.length() > maxLength.value()) {
                            throw new IllegalArgumentException("Username exceeds maximum length of " + maxLength.value() + " characters");
                        }
                    }
                    this.username = username;
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }

            // Getter for username
            public String getUsername() {
                return username;
            }
        }

        // Main method to test the annotation and validation
        public static void main(String[] args) {
            try {
                // Creating a User object with a valid username
                User user1 = new User("Alice");
                System.out.println("User1 username: " + user1.getUsername());

                // Creating a User object with an invalid username
                User user2 = new User("ThisUsernameIsTooLong"); // This should throw an IllegalArgumentException
                System.out.println("User2 username: " + user2.getUsername());
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

