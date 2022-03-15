package ro.pex.movie.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.pex.movie.model.converter.TransactionConverter;
import ro.pex.movie.model.dto.TransactionDto;
import ro.pex.movie.model.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionConverter transactionConverter;
	
	
	public List<TransactionDto> getAll(){
		return transactionRepository.findAll().stream().map(transactionConverter::converToDto).collect(Collectors.toList());
	}
	
}
