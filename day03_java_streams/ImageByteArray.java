package day03_java_streams;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageByteArray {
    public static void main(String[] args) {
        String sourceImagePath = "C:\\Users\\Hp\\Downloads\\WhatsApp Image 2025-02-01 at 23.21.41_b46dde4b.jpg";
        String destImagePath = "C:\\Users\\Hp\\Downloads\\WhatsApp Image 2025-02-01 at 23.21.41_b46dde4b_Copy.jpg";

        try {
            // Read the image file into a byte array
            byte[] imageBytes = Files.readAllBytes(new File(sourceImagePath).toPath());

            // Convert the byte array back to an image file
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

                int data;
                while ((data = bais.read()) != -1) {
                    baos.write(data);
                }

                // Write the byte array to the destination file
                try (FileOutputStream fos = new FileOutputStream(destImagePath)) {
                    baos.writeTo(fos);
                }
            }

            // Verify that the new file is identical to the original image
            byte[] newImageBytes = Files.readAllBytes(new File(destImagePath).toPath());
            if (Arrays.equals(imageBytes, newImageBytes)) {
                System.out.println("The new image file is identical to the original image.");
            } else {
                System.out.println("The new image file is NOT identical to the original image.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}