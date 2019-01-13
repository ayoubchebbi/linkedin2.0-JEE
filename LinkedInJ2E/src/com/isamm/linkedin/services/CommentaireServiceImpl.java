package com.isamm.linkedin.services;

import com.isamm.linkedin.DAO.CommentaireDAO;
import com.isamm.linkedin.DAO.CommentaireDAOImpl;
import com.isamm.linkedin.beans.*;

import java.util.*;

public class CommentaireServiceImpl implements CommentaireService {

    CommentaireDAO commentaireDAO = new CommentaireDAOImpl();

    @Override
    public boolean add(Commentaire commentaire) {
        return commentaireDAO.add(commentaire);
    }

    @Override
    public boolean delete(Commentaire commentaire) {
        return commentaireDAO.delete(commentaire);
    }

    @Override
    public boolean edit(Commentaire commentaire) {
        return commentaireDAO.edit(commentaire);
    }

    @Override
    public List<Commentaire> getAll() {
        return commentaireDAO.getAll();
    }

    @Override
    public Commentaire commentaire(int id) {
        return commentaireDAO.commentaire(id);
    }
}
