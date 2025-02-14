package day04_java_exceptions;

import java.io.*;

public class IOExceptionExample {
    public static void main(String[] args) {
        // Define the file name to read
        String fileName = "data.txt";

        // Try-with-resources ensures that the BufferedReader is closed automatically
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Read and print each line until end of file (EOF) is reached
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Catch IOException if the file is not found or there's an error reading the file
            System.out.println("File not found");
        }
    }
}
