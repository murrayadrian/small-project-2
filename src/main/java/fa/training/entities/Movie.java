package fa.training.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieId;
	
	private String actor;
	
	@OneToMany(mappedBy ="movieFK")
	private Set<MovieType> movieType = new HashSet<>();
	
	
	public Movie() {
	}
	
	public Movie(String actor) {
		this.actor = actor;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}
	
	public Set<MovieType> getMovieType() {
		return movieType;
	}

	public void setMovieType(Set<MovieType> movieTypeList) {
		this.movieType = movieTypeList;
	}
	public void addMovieType(MovieType movieType) {
		this.movieType.add(movieType);
		movieType.setMovieFK(this);
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", actor=" + actor + "]";
	}
	
}
