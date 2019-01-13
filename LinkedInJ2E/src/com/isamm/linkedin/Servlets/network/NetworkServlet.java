package com.isamm.linkedin.Servlets.network;

import com.isamm.linkedin.beans.*;
import com.isamm.linkedin.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NetworkServlet",urlPatterns = "/networks")
public class NetworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        FriendsServiceImpl friendsService = new FriendsServiceImpl();

        List<Users> al = friendsService.getFriendSearshService(name);
        request.setAttribute("al", al);


        request.getRequestDispatcher("/WEB-INF/network.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("user") !=  null) {
            Users user= (Users)session.getAttribute("user") ;
            FriendsServiceImpl friendsService = new FriendsServiceImpl();
            List<Users> al = friendsService.getFriendListService(user);
            request.setAttribute("al", al);
        }

        request.getRequestDispatcher("/WEB-INF/network.jsp").forward(request, response);
    }
}
