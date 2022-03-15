package ro.pex.movie.model.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MovieDto {

	@JsonIgnore
	private int id;
	
	private String title;
	
	private Integer releaseYear;
	
	private String description;
	
	private Integer stockNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}

	@Override
	public String toString() {
		return "MovieDto [title=" + title + ", releaseYear=" + releaseYear + ", description=" + description
				+ ", stockNumber=" + stockNumber + "]";
	}
	
	
}
