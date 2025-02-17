import day05_java_regex.junit.DateFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {
    private DateFormatter dateFormatter;

    @BeforeEach
    void setUp() {
        dateFormatter = new DateFormatter();
    }

    @Test
    void testValidDateFormat() {
        assertEquals("15-02-2025", dateFormatter.formatDate("2025-02-15"), "Date should be formatted correctly");
        assertEquals("01-01-2024", dateFormatter.formatDate("2024-01-01"), "Date should be formatted correctly");
        assertEquals("31-12-2023", dateFormatter.formatDate("2023-12-31"), "Date should be formatted correctly");
    }

    @Test
    void testInvalidDateFormat() {
        assertEquals("Invalid date format", dateFormatter.formatDate("15-02-2025"), "Should return an error for incorrect format");
        assertEquals("Invalid date format", dateFormatter.formatDate("2025/02/15"), "Should return an error for incorrect format");
        assertEquals("Invalid date format", dateFormatter.formatDate("2025.02.15"), "Should return an error for incorrect format");
        assertEquals("Invalid date format", dateFormatter.formatDate("random-text"), "Should return an error for non-date input");
    }

    @Test
    void testEmptyString() {
        assertEquals("Invalid date format", dateFormatter.formatDate(""), "Should return an error for empty input");
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> dateFormatter.formatDate(null), "Should throw NullPointerException for null input");
    }
}
