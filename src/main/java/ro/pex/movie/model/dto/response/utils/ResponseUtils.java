package ro.pex.movie.model.dto.response.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ro.pex.movie.model.dto.response.ResponseDto;
import ro.pex.movie.model.dto.response.StatusDto;
import ro.pex.movie.model.dto.response.enums.ResponseMessageTypeEnum;

public class ResponseUtils {
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> ResponseEntity info(HttpStatus httpStatus, String message, T content) {

		ResponseDto responseDto = new ResponseDto();
		StatusDto statusDto = new StatusDto();
		statusDto.setHttpCode(httpStatus.value());
		statusDto.setMessageDescription(message);
		statusDto.setMessageType(ResponseMessageTypeEnum.INFO.name());
		statusDto.setSuccess(true);

		responseDto.setStatus(statusDto);
		responseDto.setContent(content);
		return new ResponseEntity<ResponseDto>(responseDto, httpStatus);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ResponseEntity<ResponseDto> error(HttpStatus httpStatus, String message) {

		ResponseDto responseDto = new ResponseDto();
		StatusDto statusDto = new StatusDto();
		statusDto.setHttpCode(httpStatus.value());
		statusDto.setMessageDescription(message);
		statusDto.setMessageType(ResponseMessageTypeEnum.DANGER.name());
		statusDto.setSuccess(false);

		responseDto.setStatus(statusDto);
		responseDto.setContent(null);
		return new ResponseEntity<ResponseDto>(responseDto, httpStatus);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ResponseEntity<ResponseDto> warning(HttpStatus httpStatus, String message) {

		ResponseDto responseDto = new ResponseDto();
		StatusDto statusDto = new StatusDto();
		statusDto.setHttpCode(httpStatus.value());
		statusDto.setMessageDescription(message);
		statusDto.setMessageType(ResponseMessageTypeEnum.WARNING.name());
		statusDto.setSuccess(false);

		responseDto.setStatus(statusDto);
		responseDto.setContent(null);
		return new ResponseEntity<ResponseDto>(responseDto, httpStatus);

	}

}
