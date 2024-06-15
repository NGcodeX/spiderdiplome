package com.spiderdiplometest.unit.authentication;

import com.spiderdiplome.security.hashing.PasswordHashing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PasswordHashingTest {

    private PasswordHashing passwordHashing;
    private Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    @BeforeEach
    public void setUp() {
        passwordHashing = new PasswordHashing();
    }

    @Test
    public void testGenerateSalt() {
        String salt = passwordHashing.generateSalt();
        assertNotNull(salt);

        // Decode the salt back to bytes
        byte[] decodedSalt = Base64.getUrlDecoder().decode(salt);

        // Now check the length of the decoded salt
        assertEquals(16, decodedSalt.length);
    }

    @Test
    public void testHash() {
        String password = "testPassword";
        String salt = passwordHashing.generateSalt();
        String hashedPassword = passwordHashing.hash(password, salt);
        assertNotNull(hashedPassword);
        assertEquals(88, hashedPassword.length());
    }
}
