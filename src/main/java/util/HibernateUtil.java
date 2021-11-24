package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author Nikita Gvardeev
 * 24.11.2021
 */
public class HibernateUtil {

    private final static HibernateUtil INSTANCE = new HibernateUtil();
    private static SessionFactory sessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
        }
    }

    private HibernateUtil() { }

    public static HibernateUtil hibernateUtil() {
        return INSTANCE;
    }

    public SessionFactory sessionFactory() {
        return sessionFactory;
    }

    public void shoutDown() {
        sessionFactory.close();
    }
}
