package com.sharadkhanal.khajagharservice.user;

import lombok.Data;

@Data
public class UserCreateDto {
	public static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String email;
	private String contactNumber;
	private String password;
	private String role;

}
