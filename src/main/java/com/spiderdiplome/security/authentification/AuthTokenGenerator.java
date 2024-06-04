package com.spiderdiplome.security.authentification;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AuthTokenGenerator {
    private static final String SECRET_KEY = generateSecretKey();

    private static String generateSecretKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(secureRandom);
            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey.getEncoded().toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String generateAuthToken(String userId) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        long currentTimeMillis = System.currentTimeMillis();
        long expMillis = currentTimeMillis + 900000; // 15 minutes
        Date exp = new Date(expMillis);
        return JWT.create()
                .withClaim("userId", userId)
                .withExpiresAt(exp)
                .sign(algorithm);
    }

    public static String verifyAuthToken(String authToken) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(authToken);
            return jwt.getClaim("userId").asString();
        } catch (Exception e) {
            return null;
        }
    }
    // write the updateToken method here
    public static String generateToken() {
        int tokenLength = 32; // Longueur du token souhaitée
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[tokenLength];
        secureRandom.nextBytes(tokenBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }
}
