package day06_annotations_reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

    public class GreetingLoggingProxy implements InvocationHandler {
        private Object target;

        public GreetingLoggingProxy(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // Log the method name
            System.out.println("Calling method: " + method.getName());

            // Execute the method on the target object
            return method.invoke(target, args);
        }

        @SuppressWarnings("unchecked")
        public static <T> T createProxy(Object target, Class<T> interfaceType) {
            return (T) Proxy.newProxyInstance(
                    interfaceType.getClassLoader(),
                    new Class<?>[]{interfaceType},
                    new GreetingLoggingProxy(target)
            );
        }
    }
