package com.spiderdiplometest.unit.authentication;

import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.security.authentification.AuthenticationService;
import com.spiderdiplome.security.hashing.PasswordHashing;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    private AuthenticationService authenticationService;
    private UtilisateurDAOImpl utilisateurDAO;
    private PasswordHashing passwordHashing;

    @BeforeEach
    public void setUp() {
        utilisateurDAO = mock(UtilisateurDAOImpl.class);
        passwordHashing = mock(PasswordHashing.class);
        authenticationService = new AuthenticationService(utilisateurDAO, passwordHashing);
    }

    @Test
    public void testAuthenticate() {
        String matricule = "testMatricule";
        String password = "testPassword";
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMotDePasse(password);
        utilisateur.setSalt("testSalt");

        when(utilisateurDAO.findByMatricule(matricule)).thenReturn(utilisateur);
        when(passwordHashing.hash(password, utilisateur.getSalt())).thenReturn(password);

        assertTrue(authenticationService.authenticate(matricule, password));
    }

    @Test
    public void testRegister() {
        String firstname = "testFirstname";
        String lastname = "testLastname";
        String phoneEmail = "test@gmail.com";
        String password = "testPassword";
        String salt = "testSalt";
        String hashedPassword = "testHashedPassword";

        when(utilisateurDAO.findByPhone(phoneEmail)).thenReturn(null);
        when(utilisateurDAO.findByEmail(phoneEmail)).thenReturn(null);
        when(passwordHashing.generateSalt()).thenReturn(salt);
        when(passwordHashing.hash(password, salt)).thenReturn(hashedPassword);
        when(utilisateurDAO.create(any(Utilisateur.class))).thenReturn(true);

        assertTrue(authenticationService.register(firstname, lastname, phoneEmail, password));
    }
}
