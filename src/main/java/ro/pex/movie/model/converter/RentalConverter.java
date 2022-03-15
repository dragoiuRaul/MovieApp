package ro.pex.movie.model.converter;

import org.springframework.stereotype.Component;

import ro.pex.movie.model.dto.RentalDto;
import ro.pex.movie.model.entity.RentalEntity;

@Component
public class RentalConverter {

	public RentalDto converToDto(RentalEntity rentalEntity) {
		
		RentalDto rentalDto = null;
		if(rentalEntity != null) {
			rentalDto = new RentalDto();
			rentalDto.setId(rentalEntity.getId());
			rentalDto.setUserEntity(rentalEntity.getUserEntity());
			rentalDto.setMovieEntity(rentalEntity.getMovieEntity());
			rentalDto.setDue(rentalEntity.getDue());
		}
		return rentalDto;
}
}
