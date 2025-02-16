package day06_annotations_reflection;

public class InjectMain {
    public static void main(String[] args) {
        InjectDIContainer container = new InjectDIContainer();

        // Register the classes
        container.register(ServiceB.class);

        // Retrieve the instance of ServiceB and use it
        ServiceB serviceB = container.getInstance(ServiceB.class);
        serviceB.execute();
    }
}
