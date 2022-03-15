package ro.pex.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.pex.movie.exception.WrongCredentialsException;
import ro.pex.movie.model.converter.UserConverter;
import ro.pex.movie.model.dto.RegisterRequestDto;
import ro.pex.movie.model.dto.UserDto;
import ro.pex.movie.model.entity.UserEntity;
import ro.pex.movie.model.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	
	public List<UserDto> getAll(){
		return userRepository.findAll().stream().map(userConverter::convertToDto).collect(Collectors.toList());
	}
	
	public UserDto getUserByUserNameAndPassword(String username, String password ) throws WrongCredentialsException {
		Optional<UserEntity> userEntityOptional = userRepository.findByUserNameAndPassword(username, password);
		
		UserEntity userEntity = userEntityOptional.orElseThrow(() -> new WrongCredentialsException("Wrong credentials"));
		return userConverter.convertToDto(userEntity);
	}
	
	public UserDto registerUser(RegisterRequestDto registerRequestDto ) throws WrongCredentialsException {
		
	UserEntity userEntity = userConverter.convertToEntity(registerRequestDto);
		UserEntity userEntityResult=userRepository.save(userEntity);
		return userConverter.convertToDto(userEntityResult);
	}

}
