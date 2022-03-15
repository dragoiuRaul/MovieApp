package ro.pex.movie.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import ro.pex.movie.service.i18n.MessagesKeys;


public class RegisterRequestDto {
	
	@NotBlank(message=MessagesKeys.VALIDATION_REGISTRATION_LASTNAME_NOTBLANK)
	private String lastName;
	
	@NotBlank(message=MessagesKeys.VALIDATION_REGISTRATION_FIRSTNAME_NOTBLANK)
	private String firstName;
	
	@NotBlank(message=MessagesKeys.VALIDATION_REGISTRATION_USERNAME_NOTBLANK)
	private String userName;
	
	@NotBlank(message=MessagesKeys.VALIDATION_REGISTRATION_PASSWORD_NOTBLANK)
	private String password;
	
	@Email(message=MessagesKeys.VALIDATION_REGISTRATION_EMAIL_VALID)
	private String email;
	
	private String phone;
	
	private LocalDate dateOfBirth;


	public String getLastName() {
		return lastName;
		
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

}
