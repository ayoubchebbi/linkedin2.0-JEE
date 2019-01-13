package com.isamm.linkedin.Servlets.profile;

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

@WebServlet(name = "ProfileServlet",urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = -1;
        HttpSession session = request.getSession();
        Users user= (Users) session.getAttribute("user") ;
        UserServiceImpl userService = new UserServiceImpl();

        if(request.getParameter("id")!=null){
            id = Integer.parseInt(request.getParameter("id"));
            user = userService.users(id);
        }else{
            user = userService.users(user.getId());
        }
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
