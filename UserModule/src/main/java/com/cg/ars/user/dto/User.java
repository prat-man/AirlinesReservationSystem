package com.cg.ars.user.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="User")
public class User
{
	@Id
	@NotNull(message="username cannot be empty")
	@Pattern(regexp = "[A-Za-z][A-Za-z0-9\\.\\-\\_]{7,39}",message = "Invalid Username. Must be atleast 8 characters long. Must start with an alphabet. Can contain UPPERCASE, lowercase, digits, ., -, and _")
	private String username;

	@NotNull(message="password cannot be empty")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=-_*])(?=\\S+).{8,}$",message = "Invalid Password. Must be atleast 8 characters long. Must contain atleast 1 UPPER CASE, 1 lower case, 1 digit, and 1 special character")
	private String password;
	
	@NotNull(message="Email cannot be empty")
	@Pattern(regexp = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)",message = "Invalid Email ID")
	private String email;
	
	@NotNull(message="Role cannot be empty")
	private String role;
	
	@NotNull(message="Mobile number cannot be empty")
	@Pattern(regexp = "(\\+[0-9]+([\\-\\s]?[0-9]+)*[\\-\\s]?)?(([0-9]{5}[\\-\\s]?[0-9]{5})|([0-9]{3}[\\-\\s]?[0-9]{3}[\\-\\s]?[0-9]{4}))",message = "Invalid Mobile Number")
	private String mobileNo;
	
	@Transient
	public static final String USER = "User";
	
	@Transient
	public static final String ADMIN = "Admin";
	
	@Transient
	public static final String EXECUTIVE = "Executive";

	public User() {
		super();
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", role=" + role
				+ ", mobileNo=" + mobileNo + "]";
	}
}
