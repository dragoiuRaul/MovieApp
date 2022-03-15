package ro.pex.movie.model.converter;

import org.springframework.stereotype.Component;

import ro.pex.movie.model.dto.TransactionDto;
import ro.pex.movie.model.entity.TransactionEntity;

@Component
public class TransactionConverter {

	public TransactionDto converToDto(TransactionEntity TransactionEntity) {

		TransactionDto TransactionDto = null;
		if (TransactionEntity != null) {
			TransactionDto = new TransactionDto();
			TransactionDto.setId(TransactionEntity.getId());
			TransactionDto.setUserEntity(TransactionEntity.getUserEntity());
			TransactionDto.setRentalEntity(TransactionEntity.getRentalEntity());
			TransactionDto.setQuantity(TransactionEntity.getQuantity());
		}
		return TransactionDto;
	}

}
