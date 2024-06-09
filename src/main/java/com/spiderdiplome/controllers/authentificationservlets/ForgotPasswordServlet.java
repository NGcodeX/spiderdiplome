package com.spiderdiplome.controllers.authentificationservlets;

import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.repository.dao.UtilisateurDAO;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;
import com.spiderdiplome.security.authentification.AuthTokenGenerator;
import com.spiderdiplome.security.messaging.MailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ForgotPasswordServlet", value = "/mot-de-passe-oublie", description = "ceci est le controlleur de la page de mot de passe oublié")
public class ForgotPasswordServlet extends HttpServlet{

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
        req.setAttribute("errorIdentifiantforgot", "");
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
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/forgotpassword.jsp").forward(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String emailOrPhoneOrMatricule = request.getParameter("identifiant");

        Utilisateur utilisateur = utilisateurDAO.findByEmailOrPhoneOrMatricule(emailOrPhoneOrMatricule);
        if (utilisateur == null) {
            forwardToForgotPasswordPageWithErrorMessage(request, response, "Utilisateur Inexistant. Veuillez réessayer.");
            return;
    }

        String token = AuthTokenGenerator.generateToken();
        String resetLink = generateResetLink(request, token);
        int code = generateRandomCode();

        setupSessionAttributes(request, utilisateur, token, code);

        String subject = "Réinitialisation de mot de passe Spider Diplome";
        String message = generateResetMessage(utilisateur, resetLink, code);
        MailService.sendMail(utilisateur.getEmail(), subject, message);

        request.setAttribute("successforgot", "<div class=\"alert alert-success\">\n" +
                "    <strong>Processus de Renitialisation encours!</strong> Un lien ou Code de réinitialisation de mot de passe a été envoyés à votre Telephone ou E-mail..\n" +
                "</div>");
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/forgotpassword.jsp").forward(request, response);
}

    private void setupSessionAttributes(HttpServletRequest request, Utilisateur utilisateur, String token, int code) {
        request.getSession().setAttribute("token", token);
        request.getSession().setAttribute("code", String.valueOf(code));
        request.getSession().setAttribute("identifiant", utilisateur.getMatricule());
        request.getSession().setAttribute("nom", utilisateur.getNom());
        request.getSession().setAttribute("prenom", utilisateur.getPrenom());
    }

    private int generateRandomCode() {
        return (int) ((Math.random() * 900000) + 100000);
    }

    private String generateResetMessage(Utilisateur utilisateur, String resetLink, int code) {
        StringBuilder message = new StringBuilder();
        message.append("Bonjour ").append(utilisateur.getNom()).append(" ").append(utilisateur.getPrenom()).append(",\n\n");
        message.append("Vous avez demandé à réinitialiser votre mot de passe.\n");
        message.append("Veuillez cliquer sur le lien ci-dessous pour réinitialiser votre mot de passe:\n");
        message.append("code unique de la session : ").append(code).append("\n");
        message.append(resetLink).append("\n\n");
        message.append("Si vous n'avez pas demandé à réinitialiser votre mot de passe, veuillez ignorer cet e-mail.\n\n");
        message.append("Cordialement,\n");
        message.append("L'équipe de Spider Diplome");
        return message.toString();
    }

    private void forwardToForgotPasswordPageWithErrorMessage(HttpServletRequest request, HttpServletResponse response, String errorMessage) throws ServletException, IOException {
        request.setAttribute("errorIdentifiantforgot", "<div class=\"alert alert-danger\">\n" +
                "    <strong>Erreur dans la Recherche!</strong> " + errorMessage + "\n" +
                "</div>");
        request.getRequestDispatcher("/WEB-INF/views/forgotpassword.jsp").forward(request, response);
    }

    private String generateResetLink(HttpServletRequest request, String token) {
        String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();
        String host = url.replace(uri, "/spiderdiplome_war_exploded");
        return host + "/changement-mot-passe?token=" + token;
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
