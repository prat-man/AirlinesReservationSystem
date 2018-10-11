package com.cg.ars.user.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="User")
public class User
{
	@Id
	private String username;
	
	private String password;
	
	private String email;
	
	private String role;
	
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
