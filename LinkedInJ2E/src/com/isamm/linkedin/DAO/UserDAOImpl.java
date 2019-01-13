package com.isamm.linkedin.DAO;



import java.util.*;

import com.isamm.linkedin.beans.*;
import org.hibernate.*;



public class UserDAOImpl implements UserDAO{

	@Override
	public boolean add(Users users) {

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(users);
			tx.commit();
		} catch (Exception ex) {
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;
	}

	@Override
	public boolean delete(Users users) {

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		try {

			session.delete(users);
			tx.commit();
		} catch (Exception ex) {
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;

	}


	@Override
	public boolean edit(Users users) {

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(users);
			tx.commit();
		} catch (Exception ex) {
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;

	}

	@Override
	public List<Users> getAll(){

		Session session = null;
		List<Users> listUtilisateur;
		try {
			session = HibernateUtil.currentSession();
			Query query = session.createQuery("select c from Users as c ");
			listUtilisateur = query.list();

		} catch (Exception ex) {
			HibernateUtil.closeSession();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
		return listUtilisateur;

	}

	@Override
	public Users users(int id)  throws Exception {

		Session session = null;
		try {
			session = HibernateUtil.currentSession();
			Query query = session.createQuery("select c from Users as c where c.id=:id");
			query.setLong("id", id);
			return (Users) query.uniqueResult();

		} catch (HibernateException ex) {
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	@Override
	public Users login(String email, String password)  {

		Session session = null;
		try {
			session = HibernateUtil.currentSession();
			Query query = session.createQuery("select c from Users as c where c.email =:email and c.password =:password");
			query.setString("email", email);
			query.setString("password", password);
			return (Users) query.uniqueResult();

		} catch (HibernateException ex) {
			return null;
		}

	}

	public List<Users> searshFriends(String name) {
		Session session = null;
		System.out.println("FROM DAO :" + name);
		try {
			session = HibernateUtil.currentSession();
			Query query = session.createQuery("SELECT u FROM Users as u where first_name like :name OR last_name like :name");
			query.setParameter("name", "%"+name+"%");
			return query.list();

		} catch (Exception ex) {
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

}