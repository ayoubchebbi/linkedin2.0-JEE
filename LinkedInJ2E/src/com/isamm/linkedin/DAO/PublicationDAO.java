package com.isamm.linkedin.DAO;

import com.isamm.linkedin.beans.*;

import java.util.List;

public interface PublicationDAO {

    public boolean add(Publication publication);
    public boolean delete(Publication publication);
    public boolean edit(Publication publication);
    public List<Publication> getAll();
    public Publication publication(int id) ;

}
