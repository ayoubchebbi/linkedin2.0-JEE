package com.isamm.linkedin.services;

import com.isamm.linkedin.DAO.*;
import com.isamm.linkedin.beans.*;
import java.util.*;


public class PublicationServiceImpl implements PublicationService {

	PublicationDAOImpl publicationdao = new PublicationDAOImpl ();

	@Override
	public boolean add( Publication publication ) {
		return publicationdao.add(publication);
	}

	@Override
	public boolean delete( Publication publication ) {
		return publicationdao.delete(publication);
	}

	@Override
	public boolean edit( Publication publication ) {
		return publicationdao.edit(publication);
	}

	@Override
	public List<Publication> getAll() {
		return publicationdao.getAll();
	}

	@Override
	public Publication publication(int id) {
		return publicationdao.publication(id);
	}
}
