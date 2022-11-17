package com.sharadkhanal.khajagharservice.user;

import java.util.List;

import lombok.Data;

@Data
public class UserResponseListDto {
	private List<UserResponseDto> users;
	private long total;
}
