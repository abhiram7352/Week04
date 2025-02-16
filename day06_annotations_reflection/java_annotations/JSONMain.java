package day06_annotations_reflection.java_annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

// Main class
public class JSONMain {

    // Define the custom annotation @JsonField
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface JsonField {
        String name();
    }

    // User class with annotated fields
    public static class User {
        @JsonField(name = "user_name")
        private String username;

        @JsonField(name = "user_age")
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }

        // Getters for username and age
        public String getUsername() {
            return username;
        }

        public int getAge() {
            return age;
        }
    }

    // Method to convert object to JSON string by reading annotations
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField jsonField = field.getAnnotation(JsonField.class);
                try {
                    json.append("\"").append(jsonField.name()).append("\":");
                    Object value = field.get(obj);
                    if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else {
                        json.append(value);
                    }
                    if (i < fields.length - 1) {
                        json.append(",");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        json.append("}");
        return json.toString();
    }

    // Main method to test the JSON serialization
    public static void main(String[] args) {
        User user = new User("Alice", 25);
        String jsonString = toJson(user);
        System.out.println(jsonString);
    }
}

