package fa.training.test;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import fa.training.dao.Dao;
import fa.training.dao.MovieDao;
import fa.training.dao.TypeDao;
import fa.training.entities.Movie;
import fa.training.entities.Type;
import fa.training.utils.HibernateConnection;
import service.Service;

class AppTest {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	private static Dao<Movie> movieDao = new MovieDao(); 
	private static Dao<Type> typeDao = new TypeDao();
	
	@BeforeAll
	public static void setup() {
		sessionFactory = HibernateConnection.getSessionFactory();
		System.out.println("session factory is created");
		Service.insert();
	}
	@AfterAll
	public static void tearDown() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
		System.out.println("SessionFactory is destroyed");
	}
	///////////////////////////////////////////////////////////
	
	@Test
	void getMovieById() {
		System.out.println("get movie id");
		Movie movie =  movieDao.getById(session, 1);
		Assertions.assertEquals("The Rock", movie.getActor());
	}
	@Test
	void getAllMovie() {
		System.out.println("get all movie");
		List<Movie> movieLists = movieDao.getAll(session);
		Assertions.assertFalse(movieLists.isEmpty());
	}
	@Test
	void updateMovieById() {
		System.out.println("update movie");
		Movie movie = movieDao.updateById(session, 1);;
		Assertions.assertEquals("The Rock", movie.getActor());
	}
	@Test
	@Disabled
	void deleteMovieById() {
		System.out.println("delete movie id");
		movieDao.deleteById(session,1);
		Movie movie = movieDao.getById(session, 1);
		Assertions.assertNull(movie);
	}
	
	//////////
	
	@Test
	void getTypeById() {
		System.out.println("get type");
		Type type =  typeDao.getById(session, 1);
		Assertions.assertEquals("action", type.getTypeName());
	}
	@Test
	void getAllType() {
		System.out.println("get all type");
		List<Type> typeLists = typeDao.getAll(session);
		Assertions.assertFalse(typeLists.isEmpty());
	}
	@Test
	void updateTypeById() {
		System.out.println("update type");
		Type type = typeDao.updateById(session, 1);;
		Assertions.assertEquals("changed", type.getTypeDescription());
	}
	@Test
	@Disabled
	void deleteTypeById() {
		System.out.println("delete type");
		typeDao.deleteById(session,1);
		Type type = typeDao.getById(session, 1);
		Assertions.assertNull(type);
	}
	////////////////////////////////////////////////////////////
	@BeforeEach
	public void openSession() {
		session = sessionFactory.openSession();
		System.out.println("session is created");
	}
	@AfterEach
	public void closeSession() {
		if(session != null) {
			session.close();
		}
		System.out.println("session is close\n");
	}
	
}
