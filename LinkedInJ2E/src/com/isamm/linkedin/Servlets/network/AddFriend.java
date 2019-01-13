package com.isamm.linkedin.Servlets.network;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isamm.linkedin.beans.*;
import com.isamm.linkedin.services.*;

/**
 * Servlet implementation class AddFriend
 */
@WebServlet("/AddFriend")
public class AddFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddFriend() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) {
			int id = Integer.parseInt(request.getParameter("id")); 
			Users user= (Users) session.getAttribute("user") ;
			
			FriendsServiceImpl friendsService = new FriendsServiceImpl();		
			friendsService.addFriendService((int) user.getId(),id);
		}


		response.sendRedirect("/networks");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
