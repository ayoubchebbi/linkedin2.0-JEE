package com.isamm.linkedin.services;

import com.isamm.linkedin.beans.*;

import java.util.List;

public interface JobpostulationService {

    public boolean add(Jobpostulation job);
    public boolean delete(Jobpostulation job);
    public boolean edit(Jobpostulation job);
    public List<Jobpostulation> getAll();
    public Jobpostulation jobpostulation(int id) ;

}
