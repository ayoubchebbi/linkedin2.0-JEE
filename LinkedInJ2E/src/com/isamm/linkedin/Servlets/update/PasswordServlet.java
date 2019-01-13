package com.isamm.linkedin.Servlets.update;

import com.isamm.linkedin.beans.*;
import com.isamm.linkedin.services.UserService;
import com.isamm.linkedin.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PasswordServlet",urlPatterns = "/password")
public class PasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        UserService userservice = new UserServiceImpl();

        if(request.getParameter("old").equals(user.getPassword())){
            if(request.getParameter("new").equals(request.getParameter("repeat"))){
                user.setPassword(request.getParameter("repeat"));
                userservice.edit(user);
            }else{
                request.setAttribute("msg","<div class=\"p-3 mb-2 bg-danger text-white\">Passwords are not the same</div>");
            }

        }else{
            request.setAttribute("msg","<div class=\"p-3 mb-2 bg-danger text-white\">Your password is incorrect</div>");
        }
        request.getRequestDispatcher("/WEB-INF/password.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/password.jsp").forward(request, response);

    }
}
