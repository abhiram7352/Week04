package day06_annotations_reflection;

public class JsonSerializerStudentMain {
        public static void main(String[] args) {
            // Create a Student object
            Student student = new Student("Alice", 20);

            // Convert the Student object to JSON-like string
            String jsonString = JsonSerializer.toJson(student);

            // Display the JSON-like string
            System.out.println(jsonString);
        }
    }

