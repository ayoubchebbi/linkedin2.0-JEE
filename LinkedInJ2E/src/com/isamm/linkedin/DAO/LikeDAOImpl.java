package com.isamm.linkedin.DAO;

import com.isamm.linkedin.beans.*;
import org.hibernate.*;

import java.util.List;


public class LikeDAOImpl implements LikeDAO{


    @Override
    public boolean add(Like like) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        try {

            session.save(like);
            tx.commit();

        } catch (Exception ex) {
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
        return true;

    }

    @Override
    public boolean delete(Like like) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        try {

            session.delete(like);
            tx.commit();
        } catch (Exception ex) {
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
        return true;

    }

    @Override
    public boolean edit(Like like) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        try {

            session.update(like);
            tx.commit();
        } catch (Exception ex) {
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
        return true;

    }

    @Override
    public List<Like> getAll() {

        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("select l from Like as l");
            return query.list();

        } catch (Exception ex) {
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }

    @Override
    public Like like(int id) {

        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("select f from Like as f where f.id=:id");
            query.setLong("id", id);
            return (Like) query.uniqueResult();

        } catch (HibernateException ex) {
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }
    @Override
    public Like exist(int idpub,int iduti) {

        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("select f from Like as f where f.idPublication=:idpub and f.idUtilisateur=:iduti ");
            query.setLong("idpub", idpub);
            query.setLong("iduti", iduti);
            return (Like) query.uniqueResult();

        } catch (HibernateException ex) {
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }
}
