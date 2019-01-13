package com.isamm.linkedin.services;

import com.isamm.linkedin.beans.*;

import java.util.List;

public interface JobService {

    public boolean add(Job job);
    public boolean delete(Job job);
    public boolean edit(Job job);
    public List<Job> getAll();
    public Job job(int id) ;

}
