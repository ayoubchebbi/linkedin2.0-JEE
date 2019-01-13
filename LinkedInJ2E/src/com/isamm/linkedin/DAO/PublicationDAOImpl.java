package com.isamm.linkedin.DAO;

import com.isamm.linkedin.beans.*;
import org.hibernate.*;
import java.util.*;


public class PublicationDAOImpl implements PublicationDAO {

	@Override
	public boolean add(Publication publication) {

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		try {

			session.save(publication);
			tx.commit();

		} catch (Exception ex) {
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;

	}

	@Override
	public boolean delete(Publication publication) {

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		try {

			session.delete( publication );
			tx.commit();
		} catch (Exception ex) {
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;

	}

	@Override
	public boolean edit( Publication publication ) {

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		try {

			session.update(publication);
			tx.commit();
		} catch (Exception ex) {
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;

	}

	@Override
	public List<Publication> getAll() {

		Session session = null;
		List<Message> listPublication;
		try {
			session = HibernateUtil.currentSession();
			Query query = session.createQuery("select p from Publication as p order by p.date DESC");
			return query.list();

		} catch (Exception ex) {
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	@Override
	public Publication publication(int id) {

		Session session = null;
		try {
			session = HibernateUtil.currentSession();
			Query query = session.createQuery("select p from Publication as p where p.id=:id order by p.date DESC");
			query.setLong("id", id);
			return (Publication) query.uniqueResult();

		} catch (HibernateException ex) {
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}
}
