package com.spiderdiplome.controllers.accountservlets.superadmin;

import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.repository.dao.UniversiteDAO;
import com.spiderdiplome.repository.dao.UtilisateurDAO;
import com.spiderdiplome.repository.implement.UniversiteDAOImpl;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DashboardServlet", value = "/tableau-de-bord", description = "Dashboard de l'administrateur")
public class DashboardServlet extends HttpServlet {
    private UtilisateurDAO utilisateurDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialisation du servlet
        utilisateurDAO = new UtilisateurDAOImpl();
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
                    session.setAttribute("users", utilisateurDAO.readAll());
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/v1/data/secure/superadmin-area/dashboard.jsp").forward(req, resp);
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
        // Traitement de la requête POST
    }

    @Override
    public void destroy() {
        super.destroy();
        // Nettoyage après que le servlet ait fini de traiter les requêtes
    }
}
