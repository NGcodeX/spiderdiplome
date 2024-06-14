package com.spiderdiplome.controllers.accountservlets.superadmin;

import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;
import com.spiderdiplome.security.authentification.AuthenticationService;
import com.spiderdiplome.security.tokenjjwt.TokenProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.ws.rs.core.HttpHeaders;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(description = "Lock Screen Servlet", urlPatterns = {"/verrouiller"})
public class LockScreenServlet extends HttpServlet {

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
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
            req.setAttribute("usermatricule", utilisateur.getMatricule());
            session.invalidate();
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/v1/data/secure/superadmin-area/lock_screen.jsp").forward(req, resp);
        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matricule = req.getParameter("matricule");
        String password = req.getParameter("password");
        try {
            if (authService.authenticate(matricule, password)) {
                handleSuccessfulAuthentication(req, resp, matricule);
            } else {
                forwardWithError(req, resp, "Le nom d'utilisateur ou le mot de passe que vous avez entré est incorrect. Veuillez réessayer.");
            }
        } catch (Exception e) {
            forwardWithError(req, resp, "Certaines données que vous avez entrées ne sont pas valides. Veuillez vérifier et réessayer.");
        }
    }

    private boolean isInvalid(String matricule, String password) {
        return matricule == null || matricule.isEmpty() || password == null || password.isEmpty();
    }

    private boolean isUserAlreadyLoggedIn(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        return session != null && session.getAttribute("user") != null;
    }

    private void handleSuccessfulAuthentication(HttpServletRequest req, HttpServletResponse resp, String matricule) throws IOException {
        Utilisateur utilisateur = utilisateurDAO.findByMatricule(matricule);
        HttpSession session = req.getSession(true);
        session.setAttribute("user", utilisateur);

        TokenProvider tokenProvider = (TokenProvider) getServletContext().getAttribute("tokenProvider");
        String token = tokenProvider.createToken(matricule);
        session.setAttribute("token", token);

        resp.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        Cookie userCookie = new Cookie("user_spiderdiplome", matricule);
        userCookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(userCookie);

        String redirectUrl = getRedirectUrl(utilisateur, token);
        sendSuccessResponse(resp, redirectUrl);
    }

    private String getRedirectUrl(Utilisateur utilisateur, String token) {
        switch (utilisateur.getRole()) {
            case "superadmin":
                return "tb-admin?st=" + token;
            case "user":
                return "userPage.jsp";
            default:
                return "otherPage.jsp";
        }
    }

    private void sendSuccessResponse(HttpServletResponse resp, String redirectUrl) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<div class=\"alert alert-success\">\n" +
                "\t\t\t\t\t\t\t<h3><strong>Authentification Reussie!</strong> Connexion en cours.......</h3>\n" +
                "\t\t\t\t\t\t</div>");
        out.println("<script>");
        out.println("setTimeout(function(){");
        out.println("   window.location.href = '" + redirectUrl + "';");
        out.println("}, 3000);");  // Redirection après 3 secondes
        out.println("</script>");
    }

    private void forwardWithError(HttpServletRequest req, HttpServletResponse resp, String errorMessage) throws ServletException, IOException {
        req.setAttribute("errorMessage", "<div class=\"alert alert-danger\">\n" +
                "    <strong>Erreur d'authentification!</strong> " + errorMessage + "\n" +
                "</div>");
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}