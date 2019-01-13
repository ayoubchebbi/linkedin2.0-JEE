package com.isamm.linkedin.services;

import com.isamm.linkedin.beans.*;
import java.util.*;

public interface PublicationService {

    public boolean add(Publication publication);
    public boolean delete(Publication publication);
    public boolean edit(Publication publication);
    public List<Publication> getAll();
    public Publication publication(int id) ;

}
