package com.isamm.linkedin.DAO;

import com.isamm.linkedin.beans.*;
import java.util.*;

public interface JobDAO {

    public boolean add(Job job);
    public boolean delete(Job job);
    public boolean edit(Job job);
    public List<Job> getAll();
    public Job job(int id) ;

}
