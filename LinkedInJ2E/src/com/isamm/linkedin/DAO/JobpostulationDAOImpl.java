package com.isamm.linkedin.DAO;

import com.isamm.linkedin.beans.*;
import org.hibernate.*;

import java.util.List;


public class JobpostulationDAOImpl implements JobpostulationDAO{


    @Override
    public boolean add(Jobpostulation job) {

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
    public boolean delete(Jobpostulation job) {

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
    public boolean edit(Jobpostulation job) {

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
    public List<Jobpostulation> getAll() {

        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("select j from Jobpostulation as j");
            return query.list();

        } catch (Exception ex) {
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }

    @Override
    public Jobpostulation jobpostulation(int id) {

        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("select f from Jobpostulation as f where f.id=:id");
            query.setLong("id", id);
            return (Jobpostulation) query.uniqueResult();

        } catch (HibernateException ex) {
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }
}
