package com.isamm.linkedin.DAO;

import com.isamm.linkedin.beans.*;
import org.hibernate.*;

import java.util.*;


public class JobDAOImpl implements JobDAO{


    @Override
    public boolean add(Job job) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        try {

            session.save(job);
            tx.commit();

        } catch (Exception ex) {
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
        return true;

    }

    @Override
    public boolean delete(Job job) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        try {

            session.delete(job);
            tx.commit();
        } catch (Exception ex) {
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
        return true;

    }

    @Override
    public boolean edit(Job job) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        try {

            session.update(job);
            tx.commit();
        } catch (Exception ex) {
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
        return true;

    }

    @Override
    public List<Job> getAll() {

        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("select j from Job as j");
            return query.list();

        } catch (Exception ex) {
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }

    @Override
    public Job job(int id) {

        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("select f from Job as f where f.id=:id");
            query.setLong("id", id);
            return (Job) query.uniqueResult();

        } catch (HibernateException ex) {
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }
}
