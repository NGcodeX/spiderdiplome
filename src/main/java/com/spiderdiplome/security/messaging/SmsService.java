package com.spiderdiplome.security.messaging;

public class SmsService {
    public void sendVerificationCodeToUser(String phone, String verificationCode) {
        // Initialiser l'API

        // Créer le message
        String message = "Your verification code is: " + verificationCode;

        // Envoyer le message
        // Note : Cette partie dépendra fortement de la façon dont l'API spécifique est conçue.
    }
}