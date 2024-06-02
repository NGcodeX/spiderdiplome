package com.spiderdiplome.controllers.accountservlets.superadmin;

import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/supprimer-utilisateur", description = "Supprimer un utilisateur")
public class DeleteUserServlet extends HttpServlet {

    private UtilisateurDAOImpl utilisateurDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialisation du servlet
        utilisateurDAO = new UtilisateurDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupération des paramètres de la requête
        String matricule = req.getParameter("matricule");

        // Vérification si l'utilisateur est déjà connecté
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

            // Vérification du rôle de l'utilisateur
            if (!"superadmin".equals(utilisateur.getRole())) {
                resp.sendRedirect("gestions-utilisateurs");
                return;
            }

            // Validation des entrées
            if (matricule == null) {
                resp.sendRedirect("gestions-utilisateurs");
                return;
            }

            // Suppression de l'utilisateur
            try {
                utilisateurDAO.deleteByMatricule(matricule);
                resp.sendRedirect("gestions-utilisateurs");
            } catch (Exception e) {
                resp.sendRedirect("errorPage.jsp");
            }
        } else {
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        // Nettoyage après que le servlet ait fini de traiter les requêtes
    }
}