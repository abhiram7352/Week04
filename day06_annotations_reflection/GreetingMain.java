package day06_annotations_reflection;

public class GreetingMain {
        public static void main(String[] args) {
            // Create an instance of the Greeting implementation
            Greeting greeting = new GreetingImpl();

            // Create a proxy for the Greeting implementation
            Greeting proxy = GreetingLoggingProxy.createProxy(greeting, Greeting.class);

            // Use the proxy to call the method
            proxy.sayHello("Alice");
        }
    }
