package com.spiderdiplome.controllers.authentificationservlets;

import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;
import com.spiderdiplome.security.authentification.AuthenticationService;
import com.spiderdiplome.security.tokenjjwt.SecretKeyGenerator;
import com.spiderdiplome.security.tokenjjwt.TokenProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.ws.rs.core.HttpHeaders;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConnexionServlet", value = "/connexion", description = "ceci est le controlleur de la page de connexion")
public class LoginServlet extends HttpServlet {

    private UtilisateurDAOImpl utilisateurDAO;
    private AuthenticationService authService;

    @Override
public void init() throws ServletException {
    super.init();
    // Initialisation du servlet
    utilisateurDAO = new UtilisateurDAOImpl();
    authService = new AuthenticationService();

    // Génération de la clé secrète
    String secretKey = SecretKeyGenerator.generateSecretKey();
    TokenProvider tokenProvider = new TokenProvider(secretKey, 3600000);

    // Stockage du TokenProvider dans le contexte de l'application pour une utilisation ultérieure
    getServletContext().setAttribute("tokenProvider", tokenProvider);
}

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Vérification si l'utilisateur est déjà connecté
    HttpSession session = req.getSession(false);
    req.setAttribute("errorIdentifiant", "");
    req.setAttribute("errorMessage", "");
    if (session != null && session.getAttribute("user") != null) {
        System.out.println("Utilisateur déjà connecté");
        // Si l'utilisateur est déjà connecté, redirection en fonction du rôle de l'utilisateur
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        switch (utilisateur.getRole()) {
            case "superadmin":
                resp.sendRedirect("tableau-de-bord?st=" + session.getAttribute("token"));
                break;
            case "user":
                resp.sendRedirect("userPage.jsp");
                break;
            default:
                resp.sendRedirect("otherPage.jsp");
                break;
        }
        
    } else {
        System.out.println("Utilisateur non connecté");
        // Si l'utilisateur n'est pas connecté, affichage de la page de connexion
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matricule = req.getParameter("matricule");
        String password = req.getParameter("password");

        if (isInvalid(matricule, password)) {
            forwardWithError(req, resp, "Matricule and password must not be empty");
            return;
        }

        if (isUserAlreadyLoggedIn(req)) {
            resp.sendRedirect("tableau-de-bord?st=" + req.getSession(false).getAttribute("token"));
            return;
        }

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
                return "tableau-de-bord?st=" + token;
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




