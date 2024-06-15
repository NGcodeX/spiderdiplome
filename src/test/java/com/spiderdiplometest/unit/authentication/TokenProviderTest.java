package com.spiderdiplometest.unit.authentication;

import com.spiderdiplome.security.tokenjjwt.TokenProvider;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TokenProviderTest {

    private TokenProvider tokenProvider;
    private String secretKey;
    private long validityInMilliseconds;

    @BeforeEach
    public void setUp() {
        secretKey = "testSecretKey";
        validityInMilliseconds = 3600000; // 1 hour in milliseconds
        tokenProvider = new TokenProvider(secretKey, validityInMilliseconds);
    }

    @Test
    public void testCreateToken() {
        String username = "testUsername";
        String token = tokenProvider.createToken(username);
        assertNotNull(token);
    }

    @Test
    public void testValidateToken() {
        String username = "testUsername";
        String token = tokenProvider.createToken(username);

        try {
            String validatedUsername = tokenProvider.validateToken(token);
            assertEquals(username, validatedUsername);
        } catch (JWTVerificationException e) {
            fail("Token validation failed with exception: " + e.getMessage());
        }
    }
}
