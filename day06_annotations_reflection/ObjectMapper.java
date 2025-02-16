package day06_annotations_reflection;

import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance of the given class
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Iterate through the properties map
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                // Get the field corresponding to the current property
                Field field = clazz.getDeclaredField(fieldName);

                // Set the accessibility to true to access private fields
                field.setAccessible(true);

                // Set the value of the field in the instance
                field.set(instance, fieldValue);
            }

            // Return the populated instance
            return instance;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create object", e);
        }
    }
}
