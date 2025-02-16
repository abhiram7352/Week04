package day06_annotations_reflection;

public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
}
