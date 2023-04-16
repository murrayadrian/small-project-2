package service;

import java.util.List;
import org.hibernate.Session;
import fa.training.dao.MovieDao;
import fa.training.dao.MovieTypeDao;
import fa.training.dao.TypeDao;
import fa.training.entities.Movie;
import fa.training.entities.MovieType;
import fa.training.entities.Type;
import fa.training.utils.HibernateConnection;


public class Service {
	
	private static List<Movie> movieList = new MovieDao().getMovie();
	private static List<Type> typeList = new TypeDao().getType();
	private static List<MovieType> movieTypeList = new MovieTypeDao().getMovieTypeList();
	
	private static Session session = HibernateConnection.getSessionFactory().openSession();
	
	public static void insert() {
		session.beginTransaction();
		
		Movie movie1 = movieList.get(0);
		Type type1 = typeList.get(0);
		MovieType mt1 = movieTypeList.get(0);
		movie1.addMovieType(mt1);
		type1.addMovieType(mt1);
		
		session.save(movie1);
		session.save(type1);
		session.save(mt1);
		
		Type type2 = typeList.get(1);
		MovieType mt2 = movieTypeList.get(1);
		movie1.addMovieType(mt2);
		type2.addMovieType(mt2);
		
		session.save(type2);
		session.save(mt2);
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Insert successfully...");
	}
}
