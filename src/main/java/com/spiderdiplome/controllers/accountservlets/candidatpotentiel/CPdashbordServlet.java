package com.spiderdiplome.controllers.accountservlets.candidatpotentiel;

import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.repository.dao.CandidatureDAO;
import com.spiderdiplome.repository.dao.UniversiteDAO;
import com.spiderdiplome.repository.dao.UtilisateurDAO;
import com.spiderdiplome.repository.implement.CandidatureDAOImpl;
import com.spiderdiplome.repository.implement.UniversiteDAOImpl;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Dashboard-Servlet", value = "/tb-candidatpotentiel", description = "Dashboard du candidat potentiel")
public class CPdashbordServlet extends HttpServlet {

    private UtilisateurDAO utilisateurDAO;
    private UniversiteDAO universiteDAO;
    private CandidatureDAO candidatureDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialisation du servlet
        utilisateurDAO = new UtilisateurDAOImpl();
        universiteDAO = new UniversiteDAOImpl();
        candidatureDAO = new CandidatureDAOImpl();
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
                    session.setAttribute("universite", universiteDAO.findAll());
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/v1/data/secure/superadmin-area/dashboard.jsp").forward(req, resp);
                    break;
                case "candidatpotentiel":
                    session.setAttribute("universite", universiteDAO.findAll());
                    session.setAttribute("candidature", candidatureDAO.findByUserId(utilisateur.getId()));
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/v1/data/secure/candidatpotentiel-area/cp-dashboard.jsp").forward(req, resp);
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
