package fa.training.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import fa.training.entities.Movie;

public class MovieDao implements Dao<Movie> {

	private static String GET_ALL_MOVIE = "from Movie";
	private List<Movie> movie = new ArrayList<>();
	
	public MovieDao() {
		movie.add(new Movie("The Rock"));
		movie.add(new Movie("Jason Staham"));
	}

	@Override
	public Movie getById(Session session,int id) {
		return session.find(Movie.class, id);
	}

	@Override
	public List<Movie> getAll(Session session) {
		Query<Movie> query = session.createQuery(GET_ALL_MOVIE,Movie.class);
		List<Movie> lists = query.getResultList();
		return lists;
	}

	@Override
	public Movie updateById(Session session,int id) {
		if(!session.beginTransaction().isActive()) {
			session.beginTransaction();
		}
		Movie movie = session.find(Movie.class, id);
		movie.setActor("The Rock");
		session.save(movie);
		session.getTransaction().commit();
		System.out.println("update successfully...");
		return movie;
	}

	@Override
	public void deleteById(Session session,int id) {
		if(!session.beginTransaction().isActive()) {
			session.beginTransaction();
		}
		Movie movie = session.find(Movie.class,id);
		session.delete(movie);
		session.getTransaction().commit();
	}
	
	public List<Movie> getMovie() {
		return movie;
	}

}
