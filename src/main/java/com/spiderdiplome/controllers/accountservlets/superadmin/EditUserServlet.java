package com.spiderdiplome.controllers.accountservlets.superadmin;

import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;
import com.spiderdiplome.security.hashing.PasswordHashing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EditUserServlet", value = "/editer-utilisateur", description = "Edit user")
public class EditUserServlet extends HttpServlet {

    private UtilisateurDAOImpl utilisateurDAO;
    private PasswordHashing passwordHashing;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialisation du servlet
        utilisateurDAO = new UtilisateurDAOImpl();
        passwordHashing = new PasswordHashing();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

            if ("superadmin".equals(utilisateur.getRole())) {
                String matricule = req.getParameter("matricule");

                // Validate the matricule parameter
                if (matricule == null || matricule.isEmpty()) {
                    req.setAttribute("error", "Invalid matricule");
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
                    return;
                }

                Utilisateur userToEdit = utilisateurDAO.findByMatricule(matricule);

                // Check if the user exists
                if (userToEdit == null) {
                    req.setAttribute("error", "User not found");
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
                    return;
                }

                req.setAttribute("userToEdit", userToEdit);
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/v1/data/secure/superadmin-area/edit-user.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("userPage.jsp");
            }
        } else {
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

        Utilisateur existingUser = utilisateurDAO.findByMatricule(matricule);
        if(existingUser != null){
            System.out.println("User found: " + existingUser.getMatricule());
        }
        if (existingUser == null) {
            setErrorAndRedirect(req, resp, "Aucun utilisateur avec ce matricule.");
            System.out.println("Aucun utilisateur avec ce matricule.");
            return;
        }

        int statusbd = getStatus(status);

        try {
            existingUser = updateUser(existingUser, phoneEmail, statusbd, role, firstName, lastName, password);
            utilisateurDAO.update(existingUser);
            System.out.println("Le compte a été mis à jour avec succès !");
            setSuccessAndRedirect(req, resp, "Le compte a été mis à jour avec succès !");
        } catch (Exception e) {
            setErrorAndRedirect(req, resp, "Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
        }
    }

    private Utilisateur updateUser(Utilisateur user, String phoneEmail, int status, String role, String firstName, String lastName, String password) throws Exception {
        String salt = passwordHashing.generateSalt();
        if (phoneEmail.matches("^[0-9]*$")) {
            user.setPhone(phoneEmail);
            user.setEmail("default@" + salt.substring(0, 7) + ".com");
        } else if (phoneEmail.contains("@")) {
            user.setEmail(phoneEmail);
            user.setPhone("2376" + salt.substring(0, 7));
        }
        user.setStatut(status);
        user.setRole(role);
        user.setNom(firstName);
        user.setPrenom(lastName);
        if (password != null) {
            String hashedPassword = this.passwordHashing.hash(password, salt);
            if (hashedPassword == null) {
                throw new Exception("Erreur lors du hachage du mot de passe");
            }
            user.setMotDePasse(hashedPassword);
            user.setSalt(salt);
        }
        return user;
    }

    private void setErrorAndRedirect(HttpServletRequest req, HttpServletResponse resp, String message) throws IOException {
        req.setAttribute("errorAdd", "<div class=\"alert alert-danger\">\n <strong>Erreur d'enregistrement!</strong> " + message + " Veuillez réessayer.\n</div>");
        resp.sendRedirect("ajout-utilisateur");
    }

    private void setSuccessAndRedirect(HttpServletRequest req, HttpServletResponse resp, String message) throws IOException {
        req.setAttribute("successAdd", "<div class=\"alert alert-success\">\n" + "<strong>" + message + "</strong>\n" + "</div>");
        resp.sendRedirect("gestions-utilisateurs");
    }

    private int getStatus(String status) {
        return "Actif".equals(status) ? 1 : 0;
    }

    @Override
    public void destroy() {
        super.destroy();
        // Nettoyage après que le servlet ait fini de traiter les requêtes
    }
}
