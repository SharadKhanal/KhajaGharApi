package com.sharadkhanal.khajagharservice.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sharadkhanal.khajagharservice.security.BCrypt;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public UserResponseDto addUser(UserCreateDto userCreateDto) {
		User user = new User();
		String orginalPassword = userCreateDto.getPassword();
		String encryptedPassword = BCrypt.hashpw(orginalPassword, BCrypt.gensalt());
		user.setContactNumber(userCreateDto.getContactNumber());
		user.setEmail(userCreateDto.getEmail());
		user.setPassword(encryptedPassword);
		user.setId(userCreateDto.getId());
		user.setUsername(userCreateDto.getUsername());
		User savedUser = userRepository.save(user);
		return getUserResponseDto(savedUser);

	}

	public UserResponseDto getUserResponseDto(User user) {
		UserResponseDto response = new UserResponseDto();
		response.setId(user.getId());
		response.setContactNumber(user.getContactNumber());
		response.setEmail(user.getEmail());
		response.setUsername(user.getUsername());
//		response.setPassword(user.getPassword());
		return response;
	}

	public UserResponseListDto getUsers() {
		List<UserResponseDto> userResponseDto = new ArrayList<>();
		List<User> users = (List<User>) userRepository.findAll();
		for (User user : users) {
			userResponseDto.add(getUserResponseDto(user));
		}

		UserResponseListDto response = new UserResponseListDto();
		response.setUsers(userResponseDto);
		response.setTotal((long) userResponseDto.size());
		return response;
	}

	public UserResponseDto updateUsers(long id, UserUpdateDto userUpdateDto) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setContactNumber(userUpdateDto.getContactNumber());
			user.setEmail(userUpdateDto.getEmail());
			user.setPassword(userUpdateDto.getPassword());
			user.setUsername(userUpdateDto.getUsername());

			User savedUser = userRepository.save(user);
			return getUserResponseDto(savedUser);
		}
		return null;
	}

	public UserResponseDto getUserById(long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return getUserResponseDto(optionalUser.get());
		}
		return null;
	}

	public void deleteByUserId(long id) throws Exception {

		Optional<User> optionalUser = userRepository.findById(id);

		if (optionalUser.isPresent()) {
//			User user = optionalUser.get();
			userRepository.deleteById(id);
		} else {
			throw new Exception("User having id" + " " + id + " " + "is not available");
		}
	}

	public String login(LoginRequestDto request) {

		/**
		 * 1. check user with given username if exist check password and return status
		 * 2. if user does not exist then return user not found message
		 */

		User user = userRepository.findByUsername(request.getUsername());

		if (user == null) {
			return "User does not exist. Please register first.";
		}

		boolean checkpw = BCrypt.checkpw(request.getPassword(), user.getPassword());
		if (!checkpw)
			return "Invalid password. Please type your correct password.";

		user.setLoggedIn(true);
		userRepository.save(user);

		return "Success!";
	}

	public String logout(LogoutResponseDto request) {

		User user = userRepository.findByUsername(request.getUsername());

		if (user == null) {
			return "User does not exist. Please register first.";
		}

		user.setLoggedIn(false);
		userRepository.save(user);

		return "Success!";
	}

}
