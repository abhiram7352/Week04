import day05_java_regex.junit.NumberUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {
    private final NumberUtils numberUtils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 9}) // Test with multiple values
    void testIsEven(int number) {
        boolean expected = (number % 2 == 0);
        assertEquals(expected, numberUtils.isEven(number), number + " should be " + (expected ? "even" : "odd"));
    }
}
