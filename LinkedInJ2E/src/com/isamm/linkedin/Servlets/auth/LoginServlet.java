package com.isamm.linkedin.Servlets.auth;

import com.isamm.linkedin.beans.*;
import com.isamm.linkedin.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String email = request.getParameter("email");
        final String password = request.getParameter("password");

        //Check if login is correct
        UserService userService = new UserServiceImpl();
        Users user = new Users();
        user =  userService.login(email,password);
       // System.out.println("id   "+user.getId());

        if (user != null){
            System.out.println(String.format("Login \"%s\" successful", email));
            HttpSession session = request.getSession();
            session.setAttribute("user",user) ;

            Cookie CoEmail = new Cookie("user", user.getEmail());
            CoEmail.setMaxAge(30*60);
            response.addCookie(CoEmail);

            response.sendRedirect("/dashboard");
        } else {
            request.setAttribute("errorMessage","login ou mot de passe invalide");
            System.out.println("incorrect");
            doGet(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
