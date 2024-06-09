package com.spiderdiplome.unittest.securitytest;

import com.spiderdiplome.security.hashing.PasswordHashing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordHashingTest {
    private PasswordHashing passwordHashing;

    @BeforeEach
    public void setUp() {
        passwordHashing = new PasswordHashing();
    }

    @Test
    public void testGenerateSalt() {
        String salt = passwordHashing.generateSalt();
        assertNotNull(salt);
        assertEquals(24, salt.length());
    }

    @Test
    public void testHash() {
        String salt = passwordHashing.generateSalt();
        String password = "password";
        String hashedPassword = passwordHashing.hash(password, salt);

        assertNotNull(hashedPassword);
        assertNotEquals(password, hashedPassword);
    }

    @Test
    public void testHashConsistency() {
        String salt = passwordHashing.generateSalt();
        String password = "password";
        String hashedPassword1 = passwordHashing.hash(password, salt);
        String hashedPassword2 = passwordHashing.hash(password, salt);

        assertEquals(hashedPassword1, hashedPassword2);
    }
}