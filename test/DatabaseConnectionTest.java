import day05_java_regex.junit.DatabaseConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {
    public DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        // Initialize database connection before each test
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        // Close database connection after each test
        dbConnection.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        // Check if the connection is established successfully
        assertTrue(dbConnection.isConnected(), "Database should be connected after setUp()");
    }

    @Test
    void testConnectionClosed() {
        // Disconnect and verify that the connection is closed
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "Database should be disconnected after calling disconnect()");
    }
}
