package day03_java_streams;

import java.io.*;

public class PipedStream {
    public static void main(String[] args) {
        try {
            // Create piped input and output streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Create writer and reader threads
            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));

            // Start the threads
            writerThread.start();
            readerThread.start();

            // Wait for the threads to finish
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Writer implements Runnable {
    private PipedOutputStream pos;

    public Writer(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try (PipedOutputStream out = pos) {
            for (int i = 1; i <= 10; i++) {
                out.write(("Message " + i + "\n").getBytes());
                Thread.sleep(500); // Simulate time taken to produce data
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Reader implements Runnable {
    private PipedInputStream pis;

    public Reader(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try (PipedInputStream in = pis;
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}