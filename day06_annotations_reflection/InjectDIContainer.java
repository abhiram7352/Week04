package day06_annotations_reflection;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

    public class InjectDIContainer {

        private Map<Class<?>, Object> instances = new HashMap<>();

        public void register(Class<?> clazz) {
            try {
                // Create a new instance of the class and store it in the map
                Object instance = clazz.getDeclaredConstructor().newInstance();
                instances.put(clazz, instance);

                // Scan for fields with the @Inject annotation
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Inject.class)) {
                        // Get the type of the field
                        Class<?> fieldType = field.getType();

                        // Ensure that the field's type is registered in the container
                        if (!instances.containsKey(fieldType)) {
                            register(fieldType);
                        }

                        // Set the field's value to the instance stored in the container
                        field.setAccessible(true);
                        field.set(instance, instances.get(fieldType));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to register class", e);
            }
        }

        public <T> T getInstance(Class<T> clazz) {
            return clazz.cast(instances.get(clazz));
        }
    }

