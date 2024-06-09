package com.spiderdiplome.controllers.authentificationservlets;

import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;
import com.spiderdiplome.security.authentification.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InscriptionServlet", value = "/inscription", description = "ceci est le controlleur de la page d'inscription")
public class RegisterServlet extends HttpServlet {

    private UtilisateurDAOImpl utilisateurDAO;
    private AuthenticationService authService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialisation du servlet
        utilisateurDAO = new UtilisateurDAOImpl();
        authService = new AuthenticationService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Affichage de la page d'inscription
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String phoneEmail = req.getParameter("phoneEmail");
        String password = req.getParameter("password");
        String confpassword = req.getParameter("confpassword");

        if (!validateInput(firstname, lastname, phoneEmail, password, confpassword)) {
            forwardWithError(req, resp, "All fields must not be empty and passwords must match");
            return;
        }

        try {
            if (authService.register(firstname, lastname, phoneEmail, password)) {
                forwardWithSuccess(req, resp, "Votre compte a été créé avec succès ! Bienvenue!! Candidat. Vous pouvez maintenant vous connecter et profiter de la plateforme.");
            } else {
                forwardWithError(req, resp, "La création de votre compte a échoué ! Nous sommes désolés, il semble y avoir eu un problème. Veuillez réessayer.");
            }
        } catch (Exception e) {
            forwardWithError(req, resp, "Attention erreur: " + e.getMessage());
        }
    }

    private boolean validateInput(String firstname, String lastname, String phone, String password, String confpassword) {
        return firstname != null && !firstname.isEmpty() &&
                lastname != null && !lastname.isEmpty() &&
                phone != null && !phone.isEmpty() &&
                password != null && !password.isEmpty() &&
                confpassword != null && !confpassword.isEmpty() &&
                password.equals(confpassword);
    }

    private void forwardWithError(HttpServletRequest req, HttpServletResponse resp, String errorMessage) throws ServletException, IOException {
        req.setAttribute("errorMessage", "<div class=\"alert alert-danger\">\n" +
                "    <strong>" + errorMessage + "</strong>\n" +
                "</div>");
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
    }

    private void forwardWithSuccess(HttpServletRequest req, HttpServletResponse resp, String successMessage) throws ServletException, IOException {
        req.setAttribute("successMessage", "<div class=\"alert alert-success\">\n" +
                "    <strong>" + successMessage + "</strong>\n" +
                "</div>");
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}