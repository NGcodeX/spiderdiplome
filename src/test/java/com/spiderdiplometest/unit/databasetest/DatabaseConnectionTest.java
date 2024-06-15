package com.spiderdiplometest.unit.databasetest;

import com.spiderdiplome.database.DatabaseConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    private Connection connection;

    @BeforeEach
    public void setUp() throws Exception {
        connection = DatabaseConnection.getConnection();
    }

    @Test
    public void testGetConnection() throws Exception {
        assertNotNull(connection);
        assertTrue(connection.isValid(2));
    }

    @AfterEach
    public void tearDown() throws Exception {
        DatabaseConnection.closeConnection(connection);
    }

    @Test
    public void testCloseConnection() throws Exception {
        DatabaseConnection.closeConnection(connection);
        assertTrue(connection.isClosed());
    }
}
