package day04_java_exceptions;
import java.io.*;

public class TryWithResources {
    public static void main(String[] args) {
        String fileName = "info.txt"; // File to be read

        // Using try-with-resources to automatically close BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            // Read and print the first line of the file
            String firstLine = bufferedReader.readLine();
            System.out.println("First line: " + firstLine);
        } catch (IOException e) {
            // Handling IOException (file not found or reading error)
            System.out.println("Error reading file");
        }
    }
}
