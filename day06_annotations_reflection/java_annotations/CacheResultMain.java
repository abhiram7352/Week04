package day06_annotations_reflection.java_annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheResultMain {
     // Define the custom annotation @CacheResult
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        public @interface CacheResult {
        }

        // Class with a computationally expensive method
        public static class ExpensiveOperations {

            // Cache to store previously computed results
            private static final Map<String, Object> cache = new HashMap<>();

            @CacheResult
            public int expensiveComputation(int x) {
                // Simulate a computationally expensive operation
                System.out.println("Performing expensive computation for: " + x);
                return x * x;
            }

            // Method to get results with caching
            public Object getCachedResult(String methodName, Object... args) throws Exception {
                // Generate cache key based on method name and arguments
                StringBuilder keyBuilder = new StringBuilder(methodName);
                for (Object arg : args) {
                    keyBuilder.append("-").append(arg.toString());
                }
                String key = keyBuilder.toString();

                // Check if result is already cached
                if (cache.containsKey(key)) {
                    System.out.println("Returning cached result for: " + key);
                    return cache.get(key);
                }

                // Invoke the method and cache the result
                Method method = this.getClass().getMethod(methodName, int.class);
                Object result = method.invoke(this, args);
                cache.put(key, result);
                return result;
            }
        }

        // Main method to test the caching system
        public static void main(String[] args) {
            try {
                ExpensiveOperations operations = new ExpensiveOperations();

                // Call the method and cache the result
                int result1 = (int) operations.getCachedResult("expensiveComputation", 5);
                System.out.println("Result: " + result1);

                // Call the method again with the same input, should return cached result
                int result2 = (int) operations.getCachedResult("expensiveComputation", 5);
                System.out.println("Result: " + result2);

                // Call the method with a different input, should perform computation again
                int result3 = (int) operations.getCachedResult("expensiveComputation", 10);
                System.out.println("Result: " + result3);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

