package com.isamm.linkedin.Servlets.jobs;

import com.isamm.linkedin.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CandidateServlet",urlPatterns = "/candidate")
public class CandidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/candidate.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserService userService = new UserServiceImpl();
        JobService JobService = new JobServiceImpl();
        JobpostulationService JobpostulationService = new JobpostulationServiceImpl();

        request.setAttribute("user" , session.getAttribute("user") );
        request.setAttribute("listjob" , JobService.getAll() );
        request.setAttribute("listcandidature" , JobpostulationService.getAll() );
        request.setAttribute("listuser" , userService.getAll() );

        request.getRequestDispatcher("/WEB-INF/candidate.jsp").forward(request, response);

    }
}
