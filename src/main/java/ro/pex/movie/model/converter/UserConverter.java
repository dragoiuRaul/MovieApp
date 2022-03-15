package ro.pex.movie.model.converter;

import org.springframework.stereotype.Component;

import ro.pex.movie.model.dto.RegisterRequestDto;
import ro.pex.movie.model.dto.UserDto;
import ro.pex.movie.model.entity.UserEntity;

@Component
public class UserConverter {

	public UserDto convertToDto(UserEntity userEntity) {

		UserDto userDto = null;
		if (userEntity != null) {
			userDto = new UserDto();
			userDto.setId(userEntity.getId());
			userDto.setLastName(userEntity.getLastName());
			userDto.setFirstName(userEntity.getFirstName());
			userDto.setDateOfBirth(userEntity.getDateOfBirth());
			userDto.setFirstName(userEntity.getFirstName());
			userDto.setPhone(userEntity.getPhone());
			userDto.setEmail(userEntity.getEmail());
			userDto.setUserName(userEntity.getUserName());
		}
		return userDto;
	}

	public UserEntity convertToEntity(RegisterRequestDto userRequestDto) {

		UserEntity userEntity = null;
		if (userRequestDto != null) {
			userEntity = new UserEntity();
			userEntity.setLastName(userRequestDto.getLastName());
			userEntity.setFirstName(userRequestDto.getFirstName());
			userEntity.setPassword(userRequestDto.getPassword());
			userEntity.setUserName(userRequestDto.getUserName());
			userEntity.setDateOfBirth(userRequestDto.getDateOfBirth());
			userEntity.setFirstName(userRequestDto.getFirstName());
			userEntity.setPhone(userRequestDto.getPhone());
			userEntity.setEmail(userRequestDto.getEmail());
			userEntity.setUserName(userRequestDto.getUserName());
		}
		return userEntity;
	}

}
