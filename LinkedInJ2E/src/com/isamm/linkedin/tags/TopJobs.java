package com.isamm.linkedin.tags;

import com.isamm.linkedin.beans.*;
import com.isamm.linkedin.services.*;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class TopJobs extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        JobService jobService = new JobServiceImpl();
        Users user= (Users) getJspContext().getAttribute("user",PageContext.SESSION_SCOPE);
        List<Job> al = jobService.getAll();
        Collections.shuffle(al);

        for(int i=0;i<al.size();i++){
            out.print("<div class='job-info'>");
            out.print("<div class='job-details'>");
            out.print("<a href='/jobs'>");
            out.print("<h3>"+ al.get(i).getNomOffre()+"</h3>");
            out.print("<a>");
            out.print("<p>"+ al.get(i).getDescOffre().substring(0, Math.min(al.get(i).getDescOffre().length(), 100)) +"..</p>");
            out.print("</div>");
            out.print("<div class='hr-rate'>");
            out.print("<span>TND " + al.get(i).getPrice() + "/h</span>");
            out.print("</div>");

            out.print("</div>");
        }
    }
}
