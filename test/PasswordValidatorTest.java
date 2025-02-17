import day05_java_regex.junit.PasswordValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    private PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    void testValidPassword() {
        assertTrue(passwordValidator.isValid("StrongP4ss"), "Password should be valid");
    }

    @Test
    void testShortPassword() {
        assertFalse(passwordValidator.isValid("Short1"), "Password should be invalid due to length");
    }

    @Test
    void testNoUppercase() {
        assertFalse(passwordValidator.isValid("weakpassword1"), "Password should be invalid due to missing uppercase letter");
    }

    @Test
    void testNoDigit() {
        assertFalse(passwordValidator.isValid("NoDigitsHere"), "Password should be invalid due to missing digit");
    }

    @Test
    void testNullPassword() {
        assertFalse(passwordValidator.isValid(null), "Null password should be invalid");
    }
}
