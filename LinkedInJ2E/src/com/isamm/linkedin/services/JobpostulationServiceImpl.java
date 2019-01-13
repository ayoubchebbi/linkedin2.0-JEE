package com.isamm.linkedin.services;

import com.isamm.linkedin.DAO.*;
import com.isamm.linkedin.beans.*;

import java.util.List;


public class JobpostulationServiceImpl implements JobpostulationService {

	JobpostulationDAOImpl jobdao = new JobpostulationDAOImpl ();

	@Override
	public boolean add(Jobpostulation job) {
		return jobdao.add(job);
	}

	@Override
	public boolean delete(Jobpostulation job) {
		return jobdao.delete(job);
	}

	@Override
	public boolean edit(Jobpostulation job) {
		return jobdao.edit(job);
	}

	@Override
	public List<Jobpostulation> getAll() {
		return jobdao.getAll();
	}

	@Override
	public Jobpostulation jobpostulation(int id) {
		return jobdao.jobpostulation(id);
	}
}
