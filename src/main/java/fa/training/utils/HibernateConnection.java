package fa.training.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fa.training.entities.Movie;
import fa.training.entities.MovieType;
import fa.training.entities.Type;

public class HibernateConnection {
	
	private static SessionFactory sessionfactory = null;
	
	public static SessionFactory getSessionFactory() {
		if(sessionfactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Movie.class).addAnnotatedClass(Type.class).addAnnotatedClass(MovieType.class);
			sessionfactory = configuration.buildSessionFactory();
		}
		return sessionfactory;
	}
}
