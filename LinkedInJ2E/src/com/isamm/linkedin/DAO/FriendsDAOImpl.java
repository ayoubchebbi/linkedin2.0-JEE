package com.isamm.linkedin.DAO;

import com.isamm.linkedin.beans.*;
import org.hibernate.*;
import java.util.*;


public class FriendsDAOImpl implements FriendsDAO{


    @Override
    public boolean add(Friends friend) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(friend);
            tx.commit();
        } catch (Exception ex) {
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
        return true;

    }

    @Override
    public boolean delete(Friends friend) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        try {

            session.delete(friend);
            tx.commit();
        } catch (Exception ex) {
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
        return true;

    }

    @Override
    public boolean edit(Friends friend) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        try {

            session.update(friend);
            tx.commit();
        } catch (Exception ex) {
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
        return true;

    }

    @Override
    public List<Friends> getAll() {

        Session session = null;
        List<Friends> listFriends;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("select f from Friends as f ");
            return query.list();

        } catch (Exception ex) {
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }

    public List<Users> getFriends(int id) {
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("SELECT u FROM Users as u,Friends as f where ((u.id=f.friendid) AND (f.userid=:id)) or ((u.id=f.userid) AND (f.friendid=:id))");
            query.setLong("id", id);
            return query.list();

        } catch (Exception ex) {
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List<Users> getNoFriends(int id) {
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("SELECT DISTINCT u FROM Users as u where (u.id!=:id) AND (u.id not in (select friendid from Friends where userid=:id or friendid=:id))");
            query.setLong("id", id);
            return query.list();

        } catch (Exception ex) {
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void addFriend(int id1, int id2){
        Friends f = new Friends();
        f.setUserid(id1);
        f.setFriendid(id2);
        this.add(f);
    }

    public void deleteFriend(int id1,int id2){
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("select f FROM Friends as f WHERE (f.userid = :id1 AND f.friendid = :id2) or (f.userid = :id2 AND f.friendid = :id1)");
            query.setLong("id1", id1);
            query.setLong("id2", id2);
            Friends f = (Friends) query.uniqueResult();
            this.delete(f);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public Friends friend(int id) {

        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Query query = session.createQuery("select f from Friends as f where f.id=:id");
            query.setLong("id", id);
            return (Friends) query.uniqueResult();

        } catch (HibernateException ex) {
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }
}
