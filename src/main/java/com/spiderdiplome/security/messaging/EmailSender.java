package com.spiderdiplome.security.messaging;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

    public static void sendEmail(String toEmail, String subject, String body) {
        // Configuration des propriétés SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.example.com"); // Adresse du serveur SMTP
        properties.put("mail.smtp.port", "587"); // Port SMTP

        // Authentification
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("your_email@example.com", "your_password");
            }
        };

        // Création d'une session SMTP sécurisée
        Session session = Session.getInstance(properties, authenticator);

        try {
            // Création d'un message MIME
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("your_email@example.com")); // Adresse e-mail de l'expéditeur
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail)); // Adresse e-mail du destinataire
            message.setSubject(subject); // Sujet de l'e-mail
            message.setText(body); // Contenu de l'e-mail

            // Envoi du message
            Transport.send(message);
            System.out.println("E-mail sent successfully to: " + toEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
