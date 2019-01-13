package com.isamm.linkedin.DAO;



import org.hibernate.*;
import org.hibernate.cfg.*;
 
public class HibernateUtil {

  private static final SessionFactory sessionFactory;

  static {
    try {
      Configuration cfg = new Configuration();
      cfg.configure("./hibernate.cfg.xml");
      sessionFactory = cfg.buildSessionFactory();
    }
    catch (HibernateException ex) {
      throw new RuntimeException("Probl�me de configuration : " + ex.getMessage(),
                                 ex);
    }
  }
  public static final ThreadLocal session = new ThreadLocal();

  public static Session currentSession() throws HibernateException {
   Session s = (Session) session.get();
   if (s == null) {
     try {
      s = sessionFactory.openSession();
     session.set(s);
     }
     catch (Exception ex) {
       ex.printStackTrace();
     }
   }
   return s;
 }

  public static void closeSession() throws HibernateException {
    Session s = (Session) session.get();
    session.set(null);
    if (s != null) {
      s.close();
    }
  }
}
