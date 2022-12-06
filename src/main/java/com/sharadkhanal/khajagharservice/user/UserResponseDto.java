package com.sharadkhanal.khajagharservice.user;

import lombok.Data;

@Data
public class UserResponseDto {
	private Long id;
	private String username;
	private String email;
	private String contactNumber;
//	private String role;
//	private String password;
}
