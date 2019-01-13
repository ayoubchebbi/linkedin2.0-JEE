package com.isamm.linkedin.Servlets.jobs;

import com.isamm.linkedin.beans.*;
import com.isamm.linkedin.services.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ServletJobs",urlPatterns = "/jobs")
public class ServletJobs extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JobService JobService = new JobServiceImpl();
        Job job = new Job();
        HttpSession session = request.getSession();

        job.setDescOffre(request.getParameter("description"));
        job.setNomOffre(request.getParameter("name_offer"));
        job.setHashtag1(request.getParameter("hashtag1"));
        job.setHashtag2(request.getParameter("hashtag2"));
        job.setHashtag3(request.getParameter("hashtag3"));
        job.setPlace(request.getParameter("place"));
        job.setPrice(request.getParameter("price"));
        job.setDate(new Timestamp(System.currentTimeMillis()));
        job.setIdRecruteur(((Users) session.getAttribute("user")).getId());
        JobService.add(job);

        request.getRequestDispatcher("/WEB-INF/jobs.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService UsersService = new UserServiceImpl();
        JobService jobService = new JobServiceImpl();
        JobpostulationService jobpostulationService = new JobpostulationServiceImpl();

        if(request.getParameter("id" ) != null){
            if(jobService.delete(jobService.job(Integer.parseInt(request.getParameter("id" )))))
                response.sendRedirect("/jobs");
        }else if(request.getParameter("action" ) != null){

            if(request.getParameter("action" ).equals("add")){
                Jobpostulation jobpostulation = new Jobpostulation();
                jobpostulation.setIdjob(Integer.parseInt(request.getParameter("idjob" )));
                jobpostulation.setIduser(Integer.parseInt(request.getParameter("iduser" )));
                jobpostulationService.add(jobpostulation);
            }else{
                Jobpostulation jobpostulation = new Jobpostulation();
                jobpostulation.setId(Integer.parseInt(request.getParameter("idjob" )));
                jobpostulationService.delete(jobpostulation);
            }
                response.sendRedirect("/jobs");



            }else{

            request.setAttribute("user",(Users) session.getAttribute("user"));
            request.setAttribute("users",UsersService.getAll());
            request.setAttribute("jobs", jobService.getAll());
            request.setAttribute("jobpostulation", jobpostulationService.getAll());
            request.getRequestDispatcher("/WEB-INF/jobs.jsp").forward(request, response);
            }


    }
}
