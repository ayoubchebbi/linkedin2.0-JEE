package com.isamm.linkedin.DAO;

import com.isamm.linkedin.beans.*;

import java.util.*;

public interface CommentaireDAO {

    public boolean add(Commentaire commentaire);
    public boolean delete(Commentaire commentaire);
    public boolean edit(Commentaire commentaire);
    public List<Commentaire> getAll();
    public Commentaire commentaire(int id) ;

}
