package day03_java_streams;

import java.io.*;

public class ErrorLogReader {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\JAVA\\Abstract_buffered.java"; // Path to the large text file

        // Try-with-resources to ensure the BufferedReader is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Check if the line contains the word "error" (case insensitive)
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line); // Print the line if it contains "error"
                }
            }
        } catch (IOException e) {
            // Handle any IO exceptions
            e.printStackTrace();
        }
    }
}