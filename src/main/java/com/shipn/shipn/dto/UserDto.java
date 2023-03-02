package com.shipn.shipn.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserDto implements Serializable{
	
	private String id;
	private String password;
	private String email;
	private String name;
	private String auth;
	private int enabled;
	private String resetPasswordToken;
//	
//	public UserDto() {
//		
//	}
//	
//	public UserDto(String id, String password, String email, String name, String auth, int enabled, String resetPasswordToken) {
//		super();
//		this.id = id;
//		this.password = password;
//		this.email = email;
//		this.name = name;
//		this.auth = auth;
//		this.enabled = enabled;
//		this.resetPasswordToken = resetPasswordToken;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password + ", email=" + email + ", name=" + name + ", auth=" + auth + ", enabled="
				+ enabled +  ", resetPasswordToken" + resetPasswordToken +"]";
	}
	
}