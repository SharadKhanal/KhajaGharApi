package com.sharadkhanal.khajagharservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/khaja_ghar")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)

	public UserResponseDto addUser(@RequestBody UserCreateDto userCreateDto) {
		return userService.addUser(userCreateDto);

	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserResponseListDto getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public UserResponseDto getUserById(@PathVariable("id") long id) {
		return userService.getUserById(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public UserResponseDto updateUsers(@PathVariable("id") long id, @RequestBody UserUpdateDto userUpdateDto) {
		return userService.updateUsers(id, userUpdateDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteByUserId(@PathVariable long id) throws Exception {
		userService.deleteByUserId(id);
	}

	@PostMapping("/login")
	public String login(@RequestBody LoginRequestDto request) {
		return userService.login(request);
	}

	@PostMapping("/logout")
	public String logout(@RequestBody LogoutResponseDto request) {
		return userService.logout(request);
	}

}
