package com.isamm.linkedin.DAO;

import com.isamm.linkedin.beans.*;
import org.hibernate.*;
import java.util.*;


public class CommentaireDAOImpl implements CommentaireDAO{


    @Override
    public boolean add(Commentaire commentaire) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        try {

            session.save(commentaire);
            tx.commit();

        } catch (Exception ex) {
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
        return true;

    }

    @Override
    public boolean delete(Commentaire commentaire) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        try {

            session.delete(commentaire);
            tx.commit();
        } catch (Exception ex) {
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
        return true;

    }

    @Override
    public boolean edit(Commentaire commentaire) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        try {

            session.update(commentaire);
            tx.commit();
        } catch (Exception ex) {
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
        return true;

    }

    @Override
    public List<Commentaire> getAll() {

        Session session = null;
        List<Commentaire> listCommentaire;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("select f from Commentaire as f ");
            return query.list();

        } catch (Exception ex) {
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }

    @Override
    public Commentaire commentaire(int id) {

        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("select f from Commentaire as f where f.id=:id");
            query.setLong("id", id);
            return (Commentaire) query.uniqueResult();

        } catch (HibernateException ex) {
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }
}
