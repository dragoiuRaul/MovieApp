package ro.pex.movie.model.converter;

import org.springframework.stereotype.Component;

import ro.pex.movie.model.dto.MovieDto;
import ro.pex.movie.model.entity.MovieEntity;

@Component
public class MovieConverter {

	public MovieDto convertToDto(MovieEntity movieEntity) {

		MovieDto movieDto = null;
		if(movieEntity!=null) {
			movieDto=new MovieDto();
			movieDto.setId(movieEntity.getId());
			movieDto.setTitle(movieEntity.getTitle());
			movieDto.setReleaseYear(movieEntity.getReleaseYear());
			movieDto.setDescription(movieEntity.getDescription());
			movieDto.setStockNumber(movieEntity.getStockNumber());
		}
		return movieDto;
	}
}
