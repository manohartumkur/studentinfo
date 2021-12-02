package com.finonyx.app.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.finonyx.app.exception.UserNotFoundException;
import com.finonyx.app.model.User;
import com.finonyx.app.service.UserService;

@RestController
@RequestMapping("/resource")
public class UserResourceController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.retrieveAllUsers();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = userService.findUser(id);

		if (user == null) {
			throw new UserNotFoundException("User with " + id + " not present");
		}

		EntityModel<User> resource = EntityModel.of(user);

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());

		resource.add(linkTo.withRel("all-users"));

		return user;

	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userService.deleteUserById(id);

		if (user == null) {
			throw new UserNotFoundException("User with " + id + " not present");
		}

	}

	@PostMapping("/user")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {

		User savedUser = userService.saveUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}
