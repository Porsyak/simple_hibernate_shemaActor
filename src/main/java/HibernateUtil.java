import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.nio.file.Files;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            //Create the SessionFactory from hibernate.cfg.xml
            return
                    new Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch (Exception e) {
            //Make sure you log the exception, as it might be swallowed
            System.err.println("Первоначальное создание SessionFactory завершилось неудачей " + e);
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        getSessionFactory().close();
    }


}
