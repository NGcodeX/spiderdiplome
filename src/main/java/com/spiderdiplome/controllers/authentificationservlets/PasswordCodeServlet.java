package com.spiderdiplome.controllers.authentificationservlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Password Code", value = "/verification-code")
public class PasswordCodeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    String sessionToken = (String) request.getSession().getAttribute("token");
    String sentToken = request.getParameter("token");
    request.setAttribute("errorcode", "");

    if (sessionToken != null && sessionToken.equals(sentToken)) {
        // Token is valid, forward to code entry page
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/get-code.jsp").forward(request, response);
    } else {
        // Token is invalid, redirect to error page or login page
        response.sendRedirect("/mot-de-passe-oublie");
    }
}
    @Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    String userCode = request.getParameter("verificationcode");
    String sessionCode = (String) request.getSession().getAttribute("code");

    if (userCode.equals(sessionCode)) {
        // Code is correct, redirect to password change page
        response.sendRedirect("/change-password");
    } else {
        // Code is incorrect, redirect back to code entry page with error message
        request.setAttribute("errorcode", "Invalid code. Please try again.");
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/get-code.jsp").forward(request, response);
    }
}

    @Override
    public void destroy() {
        super.destroy();
    }
}
