package day06_annotations_reflection;

import java.lang.reflect.Field;

public class ConfigurationReflectionExample {

    public static void main(String[] args) {
        try {
            // Get the Class object for the Configuration class
            Class<?> configClass = Class.forName("day06_annotations_reflection.Configuration");

            // Get the private static field 'API_KEY'
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Set the accessibility to true to access the private field
            apiKeyField.setAccessible(true);

            // Retrieve the initial value of the 'API_KEY' field
            String initialApiKey = (String) apiKeyField.get(null);
            System.out.println("Initial API_KEY: " + initialApiKey);

            // Modify the value of the 'API_KEY' field
            apiKeyField.set(null, "new_api_key");

            // Retrieve the modified value of the 'API_KEY' field
            String modifiedApiKey = (String) apiKeyField.get(null);
            System.out.println("Modified API_KEY: " + modifiedApiKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
