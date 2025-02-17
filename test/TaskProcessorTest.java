import day05_java_regex.junit.TaskProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

class TaskProcessorTest {
    private final TaskProcessor taskProcessor = new TaskProcessor();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Test fails if execution exceeds 2 seconds
    void testLongRunningTask() throws InterruptedException {
        assertEquals("Task Completed", taskProcessor.longRunningTask(), "Method should complete within 2 seconds");
    }
}
