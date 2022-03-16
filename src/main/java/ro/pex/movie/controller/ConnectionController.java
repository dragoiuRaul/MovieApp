package ro.pex.movie.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.pex.movie.exception.WrongCredentialsException;
import ro.pex.movie.model.dto.EmailAttachmentDto;
import ro.pex.movie.model.dto.EmailDto;
import ro.pex.movie.model.dto.LoginRequestDto;
import ro.pex.movie.model.dto.RegisterRequestDto;
import ro.pex.movie.model.dto.UserDto;
import ro.pex.movie.model.dto.response.ResponseDto;
import ro.pex.movie.model.dto.response.StatusDto;
import ro.pex.movie.model.dto.response.utils.ResponseUtils;
import ro.pex.movie.service.UserService;
import ro.pex.movie.service.email.EmailService;
import ro.pex.movie.service.i18n.I18nService;
import ro.pex.movie.service.i18n.MessagesKeys;



@RestController
@RequestMapping("/api/auth")
public class ConnectionController {
	private Logger logger = LogManager.getLogger(ConnectionController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private I18nService i18nService;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDto> login (@RequestBody @Valid LoginRequestDto loginResponseDto) throws UnsupportedEncodingException, IOException, MessagingException{
		UserDto userDto=null;
		try {
			userDto=userService.getUserByUserNameAndPassword(loginResponseDto.getUsername(),loginResponseDto.getPassword());
		}
		catch(WrongCredentialsException e){
			
			
			return ResponseUtils.error(HttpStatus.NOT_FOUND, i18nService.getTranslation(MessagesKeys.API_LOGIN_ERROR));

		}
		
		
		return ResponseUtils.info(HttpStatus.OK, null, userDto);
		
	}
	private void testEmail() throws IOException, MessagingException, UnsupportedEncodingException {
		EmailDto mail = new EmailDto();
		mail.setFrom("dragoiurioan@gmail.com");
		mail.setTo("dragoiurioan@gmail.com");
		mail.setSubject("Spring Boot - Email Example");
		mail.setContent("TEST CONTENT");
		String path1 = "C:\\PEX2\\shopdb_user.sql";

		mail.setAttachments(List.of(
		new EmailAttachmentDto("bla", Files.readAllBytes(new File(path1).toPath())),
		new EmailAttachmentDto("bla1", Files.readAllBytes(new File(path1).toPath())),
		new EmailAttachmentDto("bla2", Files.readAllBytes(new File(path1).toPath()))));

		emailService.sendEmail(mail);
	}
	@PostMapping("/register")
	public ResponseEntity<ResponseDto> register (@RequestBody @Valid RegisterRequestDto registerRequestDto){
		UserDto userDto=null;
		try {
			userDto=userService.registerUser(registerRequestDto);
		}
		catch(WrongCredentialsException e){
			
			
			return ResponseUtils.error(HttpStatus.NOT_FOUND, i18nService.getTranslation(MessagesKeys.API_LOGIN_ERROR));

		}
		
		
		return ResponseUtils.info(HttpStatus.OK, null, userDto);
		
	}

}
