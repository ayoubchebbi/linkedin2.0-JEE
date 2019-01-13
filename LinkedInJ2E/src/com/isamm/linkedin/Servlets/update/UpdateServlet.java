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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "UpdateServlet",urlPatterns = "/edit")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        UserService userService = new UserServiceImpl();
        Users user = new Users();
        user = (Users) session.getAttribute("user");
        user.setPost( request.getParameter("post") );
        user.setEmail( request.getParameter("email") );
        user.setFirstName( request.getParameter("name") );
        user.setLastName( request.getParameter("surname") );
        user.setPhone( request.getParameter("phone") );

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
            user.setBirthDate( new java.sql.Date(date.getTime()) );


        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(userService.edit(user)){
            session.setAttribute("user",userService.users(user.getId()));
        }

        request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("user",session.getAttribute("user"));
        request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);

    }
}
