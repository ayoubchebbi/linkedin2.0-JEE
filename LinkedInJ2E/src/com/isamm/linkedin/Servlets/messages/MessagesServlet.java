package com.isamm.linkedin.Servlets.messages;

import com.isamm.linkedin.beans.*;
import com.isamm.linkedin.services.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.*;

@WebServlet(name = "MessagesServlet",urlPatterns = "/messages")
public class MessagesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date = new Date();
        HttpSession session = request.getSession();

        int id = 2;
        if(request.getParameter("id")!=null){
            id = Integer.parseInt(request.getParameter("id"));
        }

        Message message = new Message();
        MessageService messageService = new MessageServiceImpl();
        message.setBody(request.getParameter("messageToSend"));
        message.setDate(new Timestamp(date.getTime()));
        message.setSender(((Users)session.getAttribute("user")).getId());

        message.setRecipient(id);

        if(messageService.add(message)){
            response.sendRedirect("/messages?id="+id);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user= (Users)session.getAttribute("user") ;

        int id = 2;
        if(request.getParameter("id")!=null){
            id = Integer.parseInt(request.getParameter("id"));
        }

        MessageServiceImpl messageService = new MessageServiceImpl();
        FriendsServiceImpl friendsService = new FriendsServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        List<Message> al =  messageService.getBetween(user.getId(),id);
        List<Users> f = friendsService.getFriendListService(user);
        Users uu = userService.users(id);

        request.setAttribute("al", al);
        request.setAttribute("uu", uu);
        request.setAttribute("f", f);
        request.getRequestDispatcher("/WEB-INF/messages.jsp").forward(request, response);
    }
}
