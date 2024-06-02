package com.spiderdiplome.controllers.authentificationservlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/deconnexion", description = "This is the controller for the logout page")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Invalidate the session
        if (req.getSession(false) != null) {
            req.getSession(false).invalidate();
        }

        // Optionally, remove the user cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user_spiderdiplome")) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
        }

        // Redirect to the login page
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }
}