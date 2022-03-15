package ro.pex.movie.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.pex.movie.exception.WrongCredentialsException;
import ro.pex.movie.model.dto.UserDto;
import ro.pex.movie.model.dto.response.ResponseDto;
import ro.pex.movie.model.dto.response.utils.ResponseUtils;
import ro.pex.movie.service.UserService;
import ro.pex.movie.service.i18n.I18nService;
import ro.pex.movie.service.i18n.MessagesKeys;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private Logger logger = LogManager.getLogger(UserController.class);


	@Autowired
	private UserService userService;
	@Autowired
	private I18nService i18nService;
	
	@GetMapping
	public ResponseEntity<ResponseDto> getUsers() {
		List<UserDto> users = null;
		
		try {
			users=userService.getAll();
			logger.info("List of users " + users.toString());
		}
		catch(Exception e){
			
			
			return ResponseUtils.error(HttpStatus.NOT_FOUND, i18nService.getTranslation(MessagesKeys.API_LOGIN_ERROR));

		}
		
		
		return ResponseUtils.info(HttpStatus.OK, i18nService.getTranslation(MessagesKeys.API_LOGIN_ERROR), users);
	}
	
}
