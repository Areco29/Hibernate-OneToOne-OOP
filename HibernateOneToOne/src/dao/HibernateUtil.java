package dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/* Utility class for Hibernate session management.*/
public class HibernateUtil {
	private static SessionFactory sessionFactory;

	/* Retrieves the Hibernate SessionFactory instance.
	 * If not initialized, builds it using configuration from "hibernate.cfg.xml".
	 * 
	 * @return The SessionFactory instance.
	 * @throws ExceptionInInitializerError If initialization fails.
	 **/
	public static SessionFactory getSessionFactory() {
		try {
			if (sessionFactory == null) {
				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
						.configure("hibernate.cfg.xml").build();
				Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
				sessionFactory = metaData.getSessionFactoryBuilder().build();
			}
		} catch (HibernateException he) {
			System.err.println("ERROR in SessionFactory initialization: " + he);
			throw new ExceptionInInitializerError(he);
		}

		return sessionFactory;
	}
}
