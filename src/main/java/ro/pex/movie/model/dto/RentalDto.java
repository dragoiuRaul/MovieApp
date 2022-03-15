package ro.pex.movie.model.dto;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ro.pex.movie.model.entity.MovieEntity;
import ro.pex.movie.model.entity.UserEntity;


public class RentalDto {
	
	@JsonIgnore
	private int id;
	

	private UserEntity UserEntity;
	

	private MovieEntity MovieEntity;
	
	private LocalDate due;

	public LocalDate getDue() {
		return due;
	}

	public void setDue(LocalDate due) {
		this.due = due;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	
	
	
}
