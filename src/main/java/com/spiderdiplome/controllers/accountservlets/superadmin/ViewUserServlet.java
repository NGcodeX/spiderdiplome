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

@WebServlet(name = "ViewUserServlet", value = "/voir-utilisateur", description = "View user")
public class ViewUserServlet extends HttpServlet {

    private UtilisateurDAOImpl utilisateurDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialisation du servlet
        utilisateurDAO = new UtilisateurDAOImpl();
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
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/error404.jsp").forward(req, resp);
                    return;
                }

                Utilisateur userToView = utilisateurDAO.findByMatricule(matricule);

                // Check if the user exists
                if (userToView == null) {
                    req.setAttribute("error", "User not found");
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
                    return;
                }

                req.setAttribute("voirUtilisateur", userToView);
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/v1/data/secure/superadmin-area/view-user.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("userPage.jsp");
            }
        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        // Nettoyage après que le servlet ait fini de traiter les requêtes
    }


}
