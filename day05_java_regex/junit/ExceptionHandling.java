package day05_java_regex.junit;

public class ExceptionHandling {
    //Method which will throw exception
    public int divide(int a, int b) throws ArithmeticException{
        if(b==0)
            throw new ArithmeticException("Division by zero is not allowed"); //This will throw ArithmeticException

        else
            return a/b; // returns the value
    }
}
