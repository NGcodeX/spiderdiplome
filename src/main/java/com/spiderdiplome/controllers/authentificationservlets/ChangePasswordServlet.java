package com.spiderdiplome.controllers.authentificationservlets;


import com.spiderdiplome.repository.dao.UtilisateurDAO;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;
import com.spiderdiplome.security.hashing.PasswordHashing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Change the password", value="/changement-mot-passe")
public class ChangePasswordServlet extends HttpServlet {
    private UtilisateurDAO utilisateurDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        utilisateurDAO = new UtilisateurDAOImpl();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String sessionToken = (String) request.getSession().getAttribute("token");
        String sentToken = request.getParameter("token");

        if (sessionToken != null && sessionToken.equals(sentToken)) {
            // Token is valid, forward to password change page
            request.setAttribute("errorIdentifiantforgot", "<div class=\"alert alert-success\">\n" +
                    "    <strong>Changement encours...</strong> Bien vouloir memoriser votre mot de passe. Attention! ne partager a personne.\n" +
                    "</div>");
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/changepassword.jsp").forward(request, response);
        } else {
            request.setAttribute("errorIdentifiantforgot", "<div class=\"alert alert-danger\">\n" +
                    "    <strong>Erreur Le lien est invalide!</strong> Desolé mais le lien semble aparement invalide. Veuillez réessayer.\n" +
                    "</div>");
            request.getRequestDispatcher("/mot-de-passe-oublie").forward(request, response);
        }
    }
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String password = request.getParameter("password");
    String confPassword = request.getParameter("confpassword");

    // Check if the passwords match
    if (!password.equals(confPassword)) {
        request.setAttribute("errorpasss", "Passwords do not match.");
        request.setAttribute("errorpass", "*");
        request.setAttribute("errorconfpass", "*");
        request.getRequestDispatcher("/changepassword.jsp").forward(request, response);
        return;
    }

    // Get the user's username from the session
    String identifiant = (String) request.getSession().getAttribute("identifiant");

    // Hash the password
    PasswordHashing passwordHashing = new PasswordHashing();
    String salt = passwordHashing.generateSalt();
    String hashedPassword = passwordHashing.hash(password, salt);

    // Update the user's password and salt
    utilisateurDAO.updatePassword(identifiant, hashedPassword);
    utilisateurDAO.updateSalt(identifiant, salt);

    // Redirect to login page with success message
    request.setAttribute("successchangepasse", "Password updated successfully. Please login.");
    response.sendRedirect("connexion");
}

    @Override
    public void destroy() {
        super.destroy();
    }
}
