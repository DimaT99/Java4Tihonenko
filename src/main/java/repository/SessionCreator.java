package repository;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.Configuration;

import javax.persistence.Cacheable;

@Cacheable
@org.hibernate.annotations.Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE)
public class SessionCreator {
    private static final SessionFactory sessionFactory = configureSessionFactory();

    private static SessionFactory configureSessionFactory()
            throws HibernateException {
        Configuration configuration = new Configuration().configure();
        return configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}