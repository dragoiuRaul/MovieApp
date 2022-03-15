package ro.pex.movie.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserDto {
	
	@JsonIgnore
	private int id;
	
	private String lastName;
	
	private String firstName;
	
	@JsonIgnore
	private String userName;
	
	@JsonIgnore
	private String password;
	
	private String email;
	private String phone;
	private LocalDate dateOfBirth;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", userName=" + userName
				+ ", password=" + password + ", email=" + email + ", phone=" + phone + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}
	
	
	
	

}
