import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
   Unit test class for StringUtils methods.
   This class tests the reverse, palindrome check, and uppercase conversion methods.
 */
public class StringUtilsTest {

    // Creating an instance of StringUtils from the specified package.
    day05_java_regex.junit.StringUtils c = new day05_java_regex.junit.StringUtils();

    /*
     Test method for reverse().
     Ensures that the given string is correctly reversed.
     */
    @Test
    void doReverse() {
        assertEquals("marihbA", c.reverse("Abhiram"), "Reverse method failed for 'Abhiram'");
        assertEquals("luhaR", c.reverse("Rahul"), "Reverse method failed for 'Rahul'");
    }

    /*
      Test method for isPalindrome().
      Checks if a given string is correctly identified as a palindrome.
     */
    @Test
    void palindromeCheck() {
        assertTrue(c.isPalindrome("NAMAN"), "NAMAN should be a palindrome");
        assertTrue(c.isPalindrome("JAHAJ"), "JAHAJ should be a palindrome");
        assertFalse(c.isPalindrome("ABHIRAM"), "ABHIRAM is not a palindrome");
    }

    /**
     * Test method for toUpperCase().
     * Verifies that lowercase strings are converted to uppercase.
     */
    @Test
    void toUpperCase() {
        assertEquals("ABHIRAM", c.toUpperCase("abhiram"), "Uppercase conversion failed");
        assertEquals("NAMAN", c.toUpperCase("naman"), "Uppercase conversion failed");
    }
}
