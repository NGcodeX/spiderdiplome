package com.spiderdiplome.security.messaging;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class MailService {
    public static void sendMail(String to, String subject, String message) {
        // Configuration de la session mail
        final String username = "nguena.haupur@ictuniversity.edu.cm"; // Remplacez par votre adresse e-mail
        final String password = "fpmh wvcg lbfp onfx"; // Remplacez par votre mot de passe

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("nguena.haupur@ictuniversity.edu.cm")); // Remplacez par votre adresse e-mail
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setText(message);

            Transport.send(msg);

            System.out.println("Message envoyé avec succès");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

