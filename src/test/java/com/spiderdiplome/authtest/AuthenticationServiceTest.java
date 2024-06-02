package com.spiderdiplome.authtest;

import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;
import com.spiderdiplome.security.hashing.PasswordHashing;
import com.spiderdiplome.security.authentification.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    private UtilisateurDAOImpl utilisateurDAO;
    private PasswordHashing passwordHashing;
    private AuthenticationService authenticationService;

    @BeforeEach
    public void setup() {
        utilisateurDAO = Mockito.mock(UtilisateurDAOImpl.class);
        passwordHashing = Mockito.mock(PasswordHashing.class);
        authenticationService = new AuthenticationService(utilisateurDAO, passwordHashing);
    }

}
