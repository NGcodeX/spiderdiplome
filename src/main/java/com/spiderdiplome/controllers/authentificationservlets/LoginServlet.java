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
        // Récupération des paramètres de la requête
        String matricule = req.getParameter("matricule");
        String password = req.getParameter("password");

        // Vérification des paramètres de la requête
        if (matricule == null || matricule.isEmpty() || password == null || password.isEmpty()) {
            req.setAttribute("errorMessage", "Matricule and password must not be empty");
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
            return;
        }

        // Vérification si l'utilisateur est déjà connecté
        if (req.getSession(false) != null && req.getSession(false).getAttribute("user") != null) {
            resp.sendRedirect("tableau-de-bord?st=" + req.getSession(false).getAttribute("token"));
            return;
        }

        // Tentative d'authentification
        try {
            boolean isAuthenticated = authService.authenticate(matricule, password);

            if (isAuthenticated) {



                // Si l'authentification réussit, récupération de l'utilisateur
                Utilisateur utilisateur = utilisateurDAO.findByMatricule(matricule);

                // Création d'une nouvelle session pour l'utilisateur
                HttpSession session = req.getSession(true);
                session.setAttribute("user", utilisateur);

                // Récupération du TokenProvider du contexte de l'application
                TokenProvider tokenProvider = (TokenProvider) getServletContext().getAttribute("tokenProvider");

                // Génération du token
                String token = tokenProvider.createToken(matricule);
                System.out.println("Token: " + token);

                // Ajout du token à la session
                session.setAttribute("token", token);

                // Ajout du token au header de la réponse
                String authHeader = "Bearer " + token;
                System.out.println("Auth Header: " + authHeader);
                resp.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

                // Création d'un cookie avec le matricule de l'utilisateur
                Cookie userCookie = new Cookie("user_spiderdiplome", matricule);
                // Définition de la durée de vie du cookie (par exemple, une journée)
                userCookie.setMaxAge(24 * 60 * 60);
                // Ajout du cookie à la réponse
                resp.addCookie(userCookie);

                String redirectUrl = "blank.jsp";

                // Redirection en fonction du rôle de l'utilisateur
                switch (utilisateur.getRole()) {
                    case "superadmin":
                        redirectUrl= "tableau-de-bord?st=" + token;
                        System.out.println("Role: " + utilisateur.getRole());
                        break;
                    case "user":
                        resp.sendRedirect("userPage.jsp");
                        break;
                    default:
                        resp.sendRedirect("otherPage.jsp");
                        break;
                }

                // Envoi de la réponse avec le message de confirmation et le script de redirection
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

            } else {

                // Si l'authentification échoue, renvoi à la page de connexion avec un message d'erreur
                req.setAttribute("errorIdentifiant", "<a href=\"#\"><span class=\"badge badge-danger\">x</span></a>");
                req.setAttribute("errorMessage", "<div class=\"alert alert-danger\">\n" +
                        "    <strong>Erreur d'authentification!</strong> Le nom d'utilisateur ou le mot de passe que vous avez entré est incorrect. Veuillez réessayer.\n" +
                        "</div>");
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            // Gestion des exceptions
            req.setAttribute("errorMessage", "<div class=\"alert alert-danger\">\n" +
                    "    <strong>Erreur de validation!</strong> Certaines données que vous avez entrées ne sont pas valides. Veuillez vérifier et réessayer.\n" +
                    "</div>");
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}




