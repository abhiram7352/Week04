package day03_java_streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class ReadAndWriteATextFile {
    public static void main(String[] args) {
        String sourceFilePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\JAVA\\Abstract.java";
        String destinationFilePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\JAVA\\Abstract_Copy.java";

        File sourceFile = new File(sourceFilePath);

        // Check if source file exists
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist: " + sourceFilePath);
            return;
        }

        try (
                //FileInputStream to read the input
                FileInputStream fileInputStream = new FileInputStream(sourceFile);

                //FileOutputStream to print the output
                FileOutputStream fileOutputStream = new FileOutputStream(destinationFilePath)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File has been copied successfully to: " + destinationFilePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing the file.");
            e.printStackTrace();
        }
    }
}
