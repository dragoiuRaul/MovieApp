package ro.pex.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.pex.movie.model.converter.MovieConverter;
import ro.pex.movie.model.dto.MovieDto;
import ro.pex.movie.model.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private MovieConverter movieConverter;
	
	
	public List<MovieDto> getAll(){
		return movieRepository.findAll().stream().map(movieConverter::convertToDto).collect(Collectors.toList());
	}
	
}
