package day03_java_streams;

import java.io.*;

public class UpperToLower {
    public static void main(String[] args) {
        String sourceFilePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\JAVA\\Abstract.java"; // Path to the source file
        String destFilePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\JAVA\\Abstract_Desination.java"; // Path to the destination file

        // Try-with-resources to ensure resources are closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destFilePath))) {

            String line;
            // Read each line from the source file
            while ((line = reader.readLine()) != null) {
                // Convert the line to lowercase and write to the destination file
                writer.write(line.toLowerCase());
                writer.newLine(); // Add a new line after each line
            }

            System.out.println("File has been converted and saved to " + destFilePath);

        } catch (IOException e) {
            // Handle any IO exceptions
            e.printStackTrace();
        }
    }
}