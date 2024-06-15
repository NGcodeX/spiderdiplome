package com.spiderdiplome.controllers.accountservlets.superadmin;

import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;
import com.spiderdiplome.security.authentification.AuthenticationService;
import com.spiderdiplome.security.hashing.PasswordHashing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AjoutCollege", value = "/ajout-college", description = "Ajoute d un nouvelle college")
public class AddCollegeServlet extends HttpServlet {

    private UtilisateurDAOImpl utilisateurDAO;
    private AuthenticationService authService;
    private PasswordHashing passwordHashing;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialisation du servlet
        utilisateurDAO = new UtilisateurDAOImpl();
        authService = new AuthenticationService();
        passwordHashing = new PasswordHashing();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Vérification si l'utilisateur est déjà connecté
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            // Si l'utilisateur est déjà connecté, redirection en fonction du rôle de l'utilisateur
            Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

            switch (utilisateur.getRole()) {
                case "superadmin":
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/v1/data/secure/superadmin-area/add-college.jsp").forward(req, resp);
                    break;
                case "user":
                    resp.sendRedirect("userPage.jsp");
                    break;
                default:
                    resp.sendRedirect("otherPage.jsp");
                    break;
            }
        } else {
            // Si l'utilisateur n'est pas connecté, affichage de la page de connexion
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");
        String role = req.getParameter("role");
        String matricule = req.getParameter("matricule");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneEmail = req.getParameter("phoneEmail");
        String password = req.getParameter("password");

        if (isUserExists(matricule, phoneEmail)) {
            setErrorAndRedirect(req, resp, "Un utilisateur avec ce numéro de téléphone ou matricule existe déjà.");
            return;
        }

        int statusbd = getStatus(status);

        try {
            Utilisateur newUser = createUser(phoneEmail, statusbd, role, matricule, firstName, lastName, password);
            utilisateurDAO.save(newUser);

            setSuccessAndRedirect(req, resp, "Le compte a été créé avec succès ! Le Candidat peux maintenant se connecter et profiter de la plateforme.");
        } catch (Exception e) {
            setErrorAndRedirect(req, resp, "Erreur lors de l'enregistrement de l'utilisateur : " + e.getMessage());
        }
    }

    private boolean isUserExists(String matricule, String phoneEmail) {
        Utilisateur existingUserByMatricule = utilisateurDAO.findByMatricule(matricule);
        if (existingUserByMatricule != null) {
            return true;
        }

        Utilisateur existingUser;
        if (phoneEmail.matches("^[0-9]*$")) {
            existingUser = this.utilisateurDAO.findByPhone(phoneEmail);
        } else if (phoneEmail.contains("@")) {
            existingUser = this.utilisateurDAO.findByEmail(phoneEmail);
        } else {
            existingUser = null;
        }

        return existingUser != null;
    }

    private int getStatus(String status) {
        return "Actif".equals(status) ? 1 : 0;
    }

    private Utilisateur createUser(String phoneEmail, int status, String role, String matricule, String firstName, String lastName, String password) throws Exception {
        String salt = passwordHashing.generateSalt();
        Utilisateur newUser = new Utilisateur();
        if (phoneEmail.matches("^[0-9]*$")) {
            newUser.setPhone(phoneEmail);
            newUser.setEmail("default@" + salt.substring(0, 7) + ".com");
        } else if (phoneEmail.contains("@")) {
            newUser.setEmail(phoneEmail);
            newUser.setPhone("2376" + salt.substring(0, 7));
        }
        newUser.setStatut(status);
        newUser.setRole(role);
        newUser.setMatricule(matricule);
        newUser.setNom(firstName);
        newUser.setPrenom(lastName);
        String hashedPassword = this.passwordHashing.hash(password, salt);
        if (hashedPassword == null) {
            throw new Exception("Erreur lors du hachage du mot de passe");
        }
        newUser.setMotDePasse(hashedPassword);
        newUser.setSalt(salt);

        return newUser;
    }

    private void setErrorAndRedirect(HttpServletRequest req, HttpServletResponse resp, String message) throws IOException {
        req.setAttribute("errorAdd", "<div class=\"alert alert-danger\">\n <strong>Erreur d'enregistrement!</strong> " + message + " Veuillez réessayer.\n</div>");
        resp.sendRedirect("ajout-utilisateur");
    }

    private void setSuccessAndRedirect(HttpServletRequest req, HttpServletResponse resp, String message) throws IOException {
        req.setAttribute("successAdd", "<div class=\"alert alert-success\">\n" + "<strong>" + message + "</strong>\n" + "</div>");
        resp.sendRedirect("gestions-utilisateurs");
    }

    private void redirectToErrorPage(HttpServletRequest req, HttpServletResponse resp, String errorMessage) throws IOException {
        req.setAttribute("errorAdd", "<div class=\"alert alert-danger\">\n" +
                "    <strong>Erreur d'enregistrement!</strong> " + errorMessage + " Veuillez réessayer.\n" +
                "</div>");
        resp.sendRedirect("ajout-utilisateur");
    }

    @Override
    public void destroy() {
        super.destroy();
        // Nettoyage après que le servlet ait fini de traiter les requêtes
    }
}
