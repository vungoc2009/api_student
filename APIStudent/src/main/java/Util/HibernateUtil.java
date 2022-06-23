package Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory  SessionFactory() {
        SessionFactory sessionFactory = null;
        try{
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure().buildSessionFactory();
        }catch (Throwable e){
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
