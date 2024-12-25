package com.jindal.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jindal.user.entities.User;
import com.jindal.user.services.UserServices;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

	private UserServices userServices;

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User reqUser) {
		User userResponse = userServices.saveUser(reqUser);
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		User userResponse = userServices.getUser(userId);
		return ResponseEntity.ok(userResponse);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		var userResponse = userServices.getAllUser();
		return ResponseEntity.ok(userResponse);
	}

}
