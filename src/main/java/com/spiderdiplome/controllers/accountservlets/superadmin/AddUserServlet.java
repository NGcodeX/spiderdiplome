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

@WebServlet(name = "AjoutUtilisateur", value = "/ajout-utilisateur", description = "Ajoute d un nouvelle utilisateur")
public class AddUserServlet extends HttpServlet {

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
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/v1/data/secure/superadmin-area/add-user.jsp").forward(req, resp);
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
        // Récupération des paramètres de la requête
        String status = req.getParameter("status");
        System.out.println("le status est : " + status);
        String matricule = req.getParameter("matricule");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Validation des entrées
        if (status == null || matricule == null || firstName == null || lastName == null || phone == null || password == null) {
            redirectToErrorPage(req, resp, "Tous les champs sont obligatoires.");
            return;
        }

        // Vérification si l'utilisateur existe déjà
        Utilisateur existingUserByPhone = utilisateurDAO.findByPhone(phone);
        Utilisateur existingUserByMatricule = utilisateurDAO.findByMatricule(matricule);
        Utilisateur existingUserByEmail = utilisateurDAO.findByEmail(email);
        if (existingUserByPhone != null || existingUserByMatricule != null || existingUserByEmail != null) {
            // Un utilisateur avec ce numéro de téléphone ou matricule existe déjà
            req.setAttribute("errorAdd", "<div class=\"alert alert-danger\">\n <strong>Erreur d'enregistrement!</strong> Un utilisateur avec ce numéro de téléphone ou matricule existe déjà. Veuillez réessayer.\n</div>");
            resp.sendRedirect("ajout-utilisateur");
            return;
        }
        // teste si le variable status contiens le mot actif


        int statusbd = 0;
        if ("Actif".equals(status)) {
            System.out.println("le status est actif");
            statusbd = 1;
        } else if ("Inactif".equals(status)) {
            System.out.println("le status est inactif");
            statusbd = 0;
        }

        // Create new user
        try {
            Utilisateur newUser = new Utilisateur();
            newUser.setStatut(statusbd);
            newUser.setMatricule(matricule);
            newUser.setNom(firstName);
            newUser.setPrenom(lastName);
            newUser.setEmail(email);
            newUser.setPhone(phone);
            String salt = passwordHashing.generateSalt();
            String hashedPassword = this.passwordHashing.hash(password, salt);
            if (hashedPassword == null) {
                System.out.println("Erreur lors du hachage du mot de passe");
                req.setAttribute("errorAdd", "<div class=\"alert alert-danger\">\n" +
                        "    <strong>Erreur d'enregistrement!</strong> Hashage error. Veuillez réessayer.\n" +
                        "</div>");
                resp.sendRedirect("ajout-utilisateur");
                return;
            }
            newUser.setMotDePasse(hashedPassword);
            newUser.setSalt(salt);

            // Save the new user to the database
            utilisateurDAO.save(newUser);

            // Redirect to a success page
            req.setAttribute("successAdd", "<div class=\"alert alert-success\">\n" +
                    "    <strong>Le compte a été créé avec succès !</strong> Le Candidat peux maintenant se connecter et profiter de la plateforme.\n" +
                    "</div>");
            resp.sendRedirect("gestions-utilisateurs");
        } catch (Exception e) {
            // Gestion des exceptions
            redirectToErrorPage(req, resp, "Erreur lors de l'enregistrement de l'utilisateur : " + e.getMessage());
        }
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
