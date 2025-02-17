import static org.junit.jupiter.api.Assertions.*;

import day05_java_regex.junit.Calculator;
import org.junit.jupiter.api.Test;

class CalculatorTest {

     Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        assertEquals(10, calculator.add(5, 5));
        assertEquals(0, calculator.add(-5, 5));
        assertEquals(-10, calculator.add(-5, -5));
    }

    @Test
    void testSubtraction() {
        assertEquals(0, calculator.subtract(5, 5));
        assertEquals(-10, calculator.subtract(-5, 5));
        assertEquals(0, calculator.subtract(-5, -5));
    }



    @Test
    void testMultiplication() {
        assertEquals(25, calculator.multiply(5, 5));
        assertEquals(-25, calculator.multiply(-5, 5));
        assertEquals(25, calculator.multiply(-5, -5));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(10, 5));
        assertEquals(-2, calculator.divide(-10, 5));
        assertEquals(2, calculator.divide(-10, -5));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
