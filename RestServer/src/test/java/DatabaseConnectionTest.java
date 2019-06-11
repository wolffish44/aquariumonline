import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest
{
    @Test
    public void testDatabaseConnection()
    {
        DatabaseConnection connection = new DatabaseConnection();
        connection.connect();
    }

}