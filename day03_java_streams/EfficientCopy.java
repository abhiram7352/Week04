package day03_java_streams;

import java.io.*;

public class EfficientCopy {
        private static final int BUFFER_SIZE = 4096; // 4 KB

        public static void main(String[] args) {
            String sourceFile = "C:\\Users\\Hp\\OneDrive\\Desktop\\JAVA\\Abstract.java";
            String destFileNormal = "C:\\Users\\Hp\\OneDrive\\Desktop\\JAVA\\Abstract_normal.java";
            String destFileBuffered = "C:\\Users\\Hp\\OneDrive\\Desktop\\JAVA\\Abstract_buffered.java";


            // Copy using normal file streams
            long normalTime = copyFileUsingStreams(sourceFile, destFileNormal);

            // Copy using buffered streams
            long bufferedTime = copyFileUsingBufferedStreams(sourceFile, destFileBuffered);

            // Print the results
            System.out.println("Time taken using normal file streams: " + normalTime + " ns");
            System.out.println("Time taken using buffered streams: " + bufferedTime + " ns");
        }

    private static long copyFileUsingStreams(String source, String dest) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }

    private static long copyFileUsingBufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }
}