package ro.pex.movie.model.dto;

import javax.validation.constraints.NotBlank;

import ro.pex.movie.service.i18n.MessagesKeys;

public class LoginRequestDto {

	@NotBlank(message=MessagesKeys.VALIDATION_LOGIN_USERNAME_NOTBLANK)
	private String username;
	
	@NotBlank(message=MessagesKeys.VALIDATION_LOGIN_PASSWORD_NOTBLANK)
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
