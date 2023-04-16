package fa.training.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TYPE_ID")
	private int typeId;
	
	@Column(name="TYPE_NAME")
	private String typeName;
	
	@Column(name="TYPE_DESCRIPTION")
	private String typeDescription;
	
	@OneToMany(mappedBy = "typeFK")
	private Set<MovieType> movieType = new HashSet<>();
	
	
	public Type() {
	}
	
	public Type(String typeName) {
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDescription() {
		return typeDescription;
	}
	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}
	

	public Set<MovieType> getMovieType() {
		return movieType;
	}

	public void setMovieType(Set<MovieType> lists) {
		this.movieType = lists;
	}
	public void addMovieType(MovieType movieType) {
		this.movieType.add(movieType);
		movieType.setTypeFK(this);
	}
	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeDescription=" + typeDescription + "]";
	}
	
}
