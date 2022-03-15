package ro.pex.movie.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieEntity extends AbstractEntity {

	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="release_year", nullable=false)
	private Integer releaseYear;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="stock_nr", nullable=false)
	private Integer stockNumber;

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
	
	
}
