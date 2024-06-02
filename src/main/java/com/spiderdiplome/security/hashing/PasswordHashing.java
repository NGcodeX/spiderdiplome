package com.spiderdiplome.security.hashing;

import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PasswordHashing {

    private static final SecureRandom secureRandom = new SecureRandom(); // SecureRandom est sûr pour le sel
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); // Encoder pour le sel

    public String generateSalt() {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return base64Encoder.encodeToString(salt);
    }

    public String hash(String password, String salt) {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 10000, 512);
        SecretKeyFactory skf;
        byte[] hashedPassword;
        try {
            skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            hashedPassword = skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Error while hashing password", e);
        }
        return base64Encoder.encodeToString(hashedPassword);
    }
}