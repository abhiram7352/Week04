package day06_annotations_reflection;


    public class SampleClassMain {
        public static void main(String[] args) {
            // Create an instance of SampleClass
            SampleClass sample = new SampleClass();

            // Measure the execution time of method1
            SampleClassMethodTimer.measureExecutionTime(sample, "method1");

            // Measure the execution time of method2
            SampleClassMethodTimer.measureExecutionTime(sample, "method2");
        }
    }

