import day05_java_regex.junit.ExceptionHandling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionHandlingTest {


    ExceptionHandling exceptionHandling = new ExceptionHandling();

    @Test
    void testDivideByZeroException() {  //Handling the Arithmetic Exception
        Exception exception = assertThrows(ArithmeticException.class, () -> exceptionHandling.divide(10, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    void testValidDivision() { //Printing the result if b!=0
        assertEquals(5, exceptionHandling.divide(10, 2), "10 divided by 2 should be 5");


    }
}
