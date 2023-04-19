package com.bilgeadam.utility;

import com.bilgeadam.entity.Post;
import com.bilgeadam.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static final SessionFactory SESSION_FACTORY =sessionFactoryHibernate();

    private static SessionFactory sessionFactoryHibernate() {

        try {
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Post.class);

            SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            return sessionFactory;
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }


}
