package day06_annotations_reflection;

import java.util.HashMap;
import java.util.Map;

public class ObjectMapperMain {
    public static void main(String[] args) {
        // Define a map of properties
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Alice");
        properties.put("age", 20);

        // Create and populate a Student object using the ObjectMapper
        Student student = ObjectMapper.toObject(Student.class, properties);

        // Display the created Student object
        System.out.println(student);
    }
}
