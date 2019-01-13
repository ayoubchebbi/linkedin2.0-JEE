package com.isamm.linkedin.Servlets.dashboard;

import com.isamm.linkedin.beans.*;
import com.isamm.linkedin.services.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Date;

@WebServlet(name = "DashboardServlet",urlPatterns = "/dashboard")
@MultipartConfig
public class DashboardServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Publication publication = new Publication();
        PublicationService PublicationService = new PublicationServiceImpl();
        HttpSession session = request.getSession();
        Date date = new Date();

        String name = request.getServletPath();
        if(name.endsWith("/dashboard")) {
            if(request.getParameter("idpub" ) != null){
                Commentaire comm = new Commentaire();
                CommentaireService commSer = new CommentaireServiceImpl();
                comm.setContenu((String) request.getParameter("comment"));
                comm.setDate(new Timestamp(date.getTime()));
                comm.setIdutilisateur(((Users)session.getAttribute("user")).getId());
                comm.setIdpublication(Integer.parseInt(request.getParameter("idpub" )));


                if(commSer.add(comm))
                    response.sendRedirect("/dashboard");
            }else{
                publication.setContenu((String) request.getParameter("contenu"));
                publication.setDate(new Timestamp(date.getTime()));
                publication.setIdUtilisateur(((Users)session.getAttribute("user")).getId());
                Part fileimage = request.getPart("image");



                if(fileimage.getSize() != 0 ){

                    fileimage.write(getNomFichier( fileimage )+"");
                    publication.setImage(getNomFichier( fileimage ));
                }else{
                    publication.setImage("empty");
                }


                PublicationService.add(publication);

                response.sendRedirect("/dashboard");

            }

        }
    }
    private static String getNomFichier( Part part ) {
        /* Boucle sur chacun des paramètres de l'en-tête "content-disposition". */
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            /* Recherche de l'éventuelle présence du paramètre "filename". */
            if ( contentDisposition.trim().startsWith("filename") ) {
                /* Si "filename" est présent, alors renvoi de sa valeur, c'est-à-dire du nom de fichier. */
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 2 ).substring(0,contentDisposition.substring( contentDisposition.indexOf( '=' ) + 2 ).length()-1);
            }
        }
        /* Et pour terminer, si rien n'a été trouvé... */
        return null;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getServletPath();
        HttpSession session = request.getSession();
        PublicationService PublicationService = new PublicationServiceImpl();
        UserService UsersService = new UserServiceImpl();
        CommentaireService commSer = new CommentaireServiceImpl();
        LikeService likeservice = new LikeServiceImpl();

        if(name.endsWith("/dashboard")) {
            if(request.getParameter("idlike" ) != null){

                Like like = new Like();
                like.setDate(new Timestamp(System.currentTimeMillis()));
                like.setIdPublication(Integer.parseInt(request.getParameter("idlike" )));
                like.setIdUtilisateur(((Users) session.getAttribute("user")).getId());

                request.setAttribute("ddd",likeservice.exist(like.getIdPublication(),like.getIdPublication()));
                Like like2 = likeservice.exist(like.getIdPublication(),like.getIdUtilisateur());
                if( like2 == null ){
                    if(likeservice.add(like)){
                        response.sendRedirect("/dashboard");
                    }
                }else{
                    if(likeservice.delete(likeservice.exist(like.getIdPublication(),like.getIdUtilisateur()))){
                        response.sendRedirect("/dashboard");
                    }
                }


            }else if(request.getParameter("idcomm" ) != null){

                if(commSer.delete(commSer.commentaire(Integer.parseInt(request.getParameter("idcomm" )))))
                    response.sendRedirect("/dashboard");
            }else if(request.getParameter("id" ) != null){
                if(PublicationService.delete(PublicationService.publication(Integer.parseInt(request.getParameter("id" )))))
                    response.sendRedirect("/dashboard");
            }else{
                request.setAttribute("publications", PublicationService.getAll());
                request.setAttribute("likes", likeservice.getAll());
                request.setAttribute("user",(Users) session.getAttribute("user"));
                request.setAttribute("commentaire",commSer.getAll());
                request.setAttribute("users",UsersService.getAll());
                request.getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
            }
        }
    }
}
