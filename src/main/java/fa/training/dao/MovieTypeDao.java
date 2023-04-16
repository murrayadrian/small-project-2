package fa.training.dao;

import java.util.ArrayList;
import java.util.List;
import fa.training.entities.MovieType;


public class MovieTypeDao {
	
	private List<MovieType> movieTypeList = new ArrayList<>();
	
	public MovieTypeDao() {
		movieTypeList.add(new MovieType("1080p"));
		movieTypeList.add(new MovieType("720p"));
		movieTypeList.add(new MovieType("480p"));
		movieTypeList.add(new MovieType("360p"));
	}
//	public void save(MovieType type, Session session) {
//		session.save(type);
//		session.getTransaction().commit();
//	}
//
//
//	public static MovieType getById(Session session) {
//		MovieType type = session.get(MovieType.class,1);
//
//		return type;
//	}
//
//	
//	public static List<MovieType> getAll(Session session) {
//		Query<Object[]> query = session.createQuery("from MovieType mvtype join mvtype.movieFK movie on mvtype.movieFK.movieId = movie.movieId",Object[].class);
//		List<Object[]> lists = query.list();
//		List<MovieType> typeLists = new ArrayList<>();
//		for(Object[] list : lists) {
//			typeLists.add((MovieType) list[0]);
//		}
//		return typeLists;
//	}
//
//	public void updateById(Integer id, Session session) {
//		MovieType type = session.find(MovieType.class, id);
//		type.setDescription("changed");
//		session.save(type);
//		session.getTransaction().commit();
//	}
//
//	public void deleteById(Integer id, Session session) {
//		MovieType type = session.find(MovieType.class,id);
//		session.delete(type);
//		session.getTransaction().commit();
//	}

	public List<MovieType> getMovieTypeList() {
		return movieTypeList;
	}
	
}
