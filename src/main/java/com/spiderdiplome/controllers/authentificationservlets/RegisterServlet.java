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
        // Récupération des paramètres de la requête
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String phoneEmail = req.getParameter("phoneEmail");
        String password = req.getParameter("password");
        String confpassword = req.getParameter("confpassword");

        // Vérification des paramètres de la requête
        if (!validateInput(firstname, lastname, phoneEmail, password, confpassword)) {
            req.setAttribute("errorMessage", "All fields must not be empty and passwords must match");
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
            return;
        }

        // Tentative d'inscription
        try {
            boolean isRegistered = authService.register(firstname, lastname, phoneEmail, password);

            if (isRegistered) {
                System.out.println("Inscription réussie!");
                req.setAttribute("successMessage", "<div class=\"alert alert-success\">\n" +
                        "    <strong>Votre compte a été créé avec succès !</strong> Bienvenue!! Candidat. Vous pouvez maintenant vous connecter et profiter de la plateforme.\n" +
                        "</div>");
                // Si l'inscription réussit, redirection vers la page de connexion
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "<div class=\"alert alert-danger\">\n" +
                        "    <strong>La création de votre compte a échoué !</strong> Nous sommes désolés, il semble y avoir eu un problème. Veuillez réessayer.\n" +
                        "</div>");
                // Si l'inscription échoue, renvoi à la page d'inscription avec un message d'erreur
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            // Gestion des exceptions
            req.setAttribute("errorMessage", "<div class=\"alert alert-danger\">\n" +
                    "    <strong>Attention erreur: </strong>" + e.getMessage() + "\n" +
                    "</div>");
            req.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
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

    @Override
    public void destroy() {
        super.destroy();
    }
}