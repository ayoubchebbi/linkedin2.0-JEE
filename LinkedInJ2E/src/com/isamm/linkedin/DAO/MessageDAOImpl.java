package com.isamm.linkedin.DAO;

import com.isamm.linkedin.beans.*;
import org.hibernate.*;
import java.util.*;


public class MessageDAOImpl implements MessageDAO {

	@Override
	public boolean add(Message message) {

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		try {

			session.save(message);
			tx.commit();

		} catch (Exception ex) {
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;

	}

	@Override
	public boolean delete(Message message) {

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		try {

			session.delete(message);
			tx.commit();
		} catch (Exception ex) {
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;

	}

	@Override
	public boolean edit(Message message) {

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		try {

			session.update(message);
			tx.commit();
		} catch (Exception ex) {
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;

	}

	@Override
	public List<Message> getAll() {

		Session session = null;
		List<Message> listMessage;
		try {
			session = HibernateUtil.currentSession();
			Query query = session.createQuery("select m from Message as m ");
			return query.list();

		} catch (Exception ex) {
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	@Override
	public List<Message> getBetween(int id1,int id2) {

		Session session = null;
		List<Message> listMessage;
		try {
			session = HibernateUtil.currentSession();
			Query query = session.createQuery("select m from Message as m where (sender=:id1 AND recipient=:id2) or (sender=:id2 AND recipient=:id1)");
			query.setLong("id1", id1);
			query.setLong("id2", id2);
			return query.list();

		} catch (Exception ex) {
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	@Override
	public Message message(int id) {

		Session session = null;
		try {
			session = HibernateUtil.currentSession();
			Query query = session.createQuery("select m from Message as m where m.id=:id");
			query.setLong("id", id);
			return (Message) query.uniqueResult();

		} catch (HibernateException ex) {
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}
}
