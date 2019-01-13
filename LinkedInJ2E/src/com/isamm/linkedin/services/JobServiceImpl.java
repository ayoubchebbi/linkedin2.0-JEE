package com.isamm.linkedin.services;

import com.isamm.linkedin.DAO.*;
import com.isamm.linkedin.beans.*;

import java.util.List;


public class JobServiceImpl implements JobService {

	JobDAOImpl jobdao = new JobDAOImpl ();

	@Override
	public boolean add(Job job) {
		return jobdao.add(job);
	}

	@Override
	public boolean delete(Job job) {
		return jobdao.delete(job);
	}

	@Override
	public boolean edit(Job job) {
		return jobdao.edit(job);
	}

	@Override
	public List<Job> getAll() {
		return jobdao.getAll();
	}

	@Override
	public Job job(int id) {
		return jobdao.job(id);
	}
}
