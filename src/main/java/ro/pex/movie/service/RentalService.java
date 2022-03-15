package ro.pex.movie.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.pex.movie.model.converter.RentalConverter;
import ro.pex.movie.model.dto.RentalDto;
import ro.pex.movie.model.repository.RentalRepository;

@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;
	
	@Autowired
	private RentalConverter rentalConverter;
	
	
	public List<RentalDto> getAll(){
		return rentalRepository.findAll().stream().map(rentalConverter::converToDto).collect(Collectors.toList());
	}
	
}
