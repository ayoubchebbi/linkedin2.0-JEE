package com.isamm.linkedin.Servlets.auth;

import com.isamm.linkedin.beans.*;
import com.isamm.linkedin.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userservice = new UserServiceImpl();
        Users user = new Users();

        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final String confirm_password = request.getParameter("confirm_password");
        final String first_name = request.getParameter("first_name");
        final String last_name = request.getParameter("last_name");

        Users users = new Users();
        users.setEmail(email);
        users.setPassword(password);
        users.setFirstName(first_name);
        users.setLastName(last_name);
        users.setPhone(last_name);
        users.setPost("Java developer");
        users.setSex("Male");
        users.setBirthDate(new Date(25));

        if(confirm_password.equals(password)){
            if(userservice.add(users)){
                HttpSession session = request.getSession();
                session.setAttribute("user",userservice.login(email,password)) ;

                Cookie CoEmail = new Cookie("user", user.getEmail());
                CoEmail.setMaxAge(30*60);
                response.addCookie(CoEmail);

                response.sendRedirect("/login");
            }else{
                request.setAttribute("errorMessage1","Probléme d'inscription");
                System.out.println("incorrect");
                doGet(request, response);
            }
        }else{
            request.setAttribute("errorMessage1","Les mots de passe ne sont pas identiques");
            doGet(request, response);
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
