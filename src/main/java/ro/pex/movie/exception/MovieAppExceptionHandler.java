package ro.pex.movie.exception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ro.pex.movie.model.dto.response.utils.ResponseUtils;
import ro.pex.movie.service.i18n.I18nService;


@ControllerAdvice
public class MovieAppExceptionHandler extends ResponseEntityExceptionHandler  {


	@Autowired
	private I18nService i18nService;
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<FieldError> listFieldError= ex.getBindingResult().getFieldErrors();
		
		String translationCode="";
		if (listFieldError != null && !listFieldError.isEmpty()) {
			
			translationCode = listFieldError.iterator().next().getDefaultMessage();
		}
		
		ResponseEntity<Object> result = new ResponseEntity<Object>(ResponseUtils.error(status, i18nService.getTranslation(translationCode)).getBody(), status);
		return result;
	}
}
