import day05_java_regex.junit.FileProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {
    private final FileProcessor fileProcessor = new FileProcessor();
    private final String testFilename = "testfile.txt";
    private final String testContent = "Hello, JUnit File Testing!";

    @BeforeEach
    void setUp() throws IOException {
        fileProcessor.writeToFile(testFilename, testContent);
    }

    @AfterEach
    void tearDown() {
        File file = new File(testFilename);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = fileProcessor.readFromFile(testFilename);
        assertEquals(testContent, content, "Content should match after writing and reading");
    }

    @Test
    void testFileExistsAfterWriting() {
        File file = new File(testFilename);
        assertTrue(file.exists(), "File should exist after writing content");
    }

    @Test
    void testReadNonExistentFile() {
        Exception exception = assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistent.txt"));
        assertTrue(exception.getMessage().contains("nonexistent"), "Should throw IOException for missing file");
    }
}
