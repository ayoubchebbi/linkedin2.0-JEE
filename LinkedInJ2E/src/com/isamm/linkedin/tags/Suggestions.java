package com.isamm.linkedin.tags;

import com.isamm.linkedin.services.FriendsServiceImpl;
import com.isamm.linkedin.beans.Users;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Suggestions extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        FriendsServiceImpl cs = new FriendsServiceImpl();
        Users user= (Users) getJspContext().getAttribute("user",PageContext.SESSION_SCOPE);

        List<Users> al2 = cs.getNoFriendListService(user);
        Collections.shuffle(al2);

        for(int i=0;i<al2.size();i++){
            out.print("<div class='suggestion-usd'>");
            out.print("<img src='/public/images/users/avatar.jpg' height='40' alt=''>");
            out.print("<div class='sgt-text'>");
            out.print("<h4><a href='/profile?id=" + al2.get(i).getId() +"'>" + al2.get(i).getFirstName() + " " + al2.get(i).getLastName() + "</a> </h4>");
            out.print("<span>"+al2.get(i).getPost()+"</span>");
            out.print("</div>");
            out.print("</div>");
        }
    }
}
