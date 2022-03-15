package ro.pex.movie.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rental")
public class RentalEntity extends AbstractEntity{

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userid", nullable = false)
	private UserEntity UserEntity;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "movieid", nullable = false)
	private MovieEntity MovieEntity;
	
	@Column(name = "due", nullable = false)
	private LocalDate due;

	public UserEntity getUserEntity() {
		return UserEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		UserEntity = userEntity;
	}

	public MovieEntity getMovieEntity() {
		return MovieEntity;
	}

	public void setMovieEntity(MovieEntity movieEntity) {
		MovieEntity = movieEntity;
	}

	public LocalDate getDue() {
		return due;
	}

	public void setDue(LocalDate due) {
		this.due = due;
	}

	

	
	 
	
}
