package day05_java_regex.junit;

public class TaskProcessor {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // Simulates a long-running task (3 seconds)
        return "Task Completed";
    }
}

