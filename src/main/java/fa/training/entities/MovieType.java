package fa.training.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class MovieType {
	
	@EmbeddedId
	private MovieTypeId id = new MovieTypeId();
	
	@ManyToOne
	@MapsId("typeId")
	@JoinColumn(name = "TYPE_ID")
	private Type typeFK;
	
	@ManyToOne
	@MapsId("movieId")
	@JoinColumn(name = "MOVIE_ID")
	private Movie movieFK;

	@Column(name = "MT_DESCRIPTION")
	private String description;

	//
	
	public MovieType() {
	}

	public MovieType(String description) {
		this.description = description;
	}

	//
	
	public Movie getMovieFK() {
		return movieFK;
	}

	public void setMovieFK(Movie movieFK) {
		this.movieFK = movieFK;
	}

	public Type getTypeFK() {
		return typeFK;
	}

	public void setTypeFK(Type typeFK) {
		this.typeFK = typeFK;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Embeddable
	public static class MovieTypeId implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private int typeId;
		private int movieId;
		
		public MovieTypeId() {
			
		}

		public MovieTypeId(int typeId, int movieId) {
			super();
			this.typeId = typeId;
			this.movieId = movieId;
		}

		public int getTypeId() {
			return typeId;
		}

		public void setTypeId(int typeId) {
			this.typeId = typeId;
		}

		public int getMovieId() {
			return movieId;
		}

		public void setMovieId(int movieId) {
			this.movieId = movieId;
		}
		
	}

}
