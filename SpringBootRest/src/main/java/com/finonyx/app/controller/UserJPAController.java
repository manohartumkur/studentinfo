package com.finonyx.app.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.finonyx.app.model.Post;
import com.finonyx.app.model.User;
import com.finonyx.app.repository.PostRepository;
import com.finonyx.app.repository.UserRepository;

@RestController
@RequestMapping("/jpa")
public class UserJPAController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PostRepository postRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable Long id) {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("User with " + id + " not present");
		}

		/*
		 * EntityModel<User> resource=EntityModel.of(user);
		 * 
		 * WebMvcLinkBuilder linkTo =
		 * linkTo(methodOn(this.getClass()).retrieveAllUsers());
		 * 
		 * resource.add(linkTo.withRel("all-users"));
		 * 
		 */
		return user.get();

	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);

	}

	@PostMapping("/user")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {

		User savedUser = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable Long id, @RequestBody Post post) {
		System.out.println(post);
		System.out.println(id);
		Optional<User> userOptional = userRepository.findById(id);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		User user = userOptional.get();

		post.setUser(user);

		postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping("/users/{id}/posts")
	public List<Post> getPosts(@PathVariable Long id) {

		Optional<User> userOptional = userRepository.findById(id);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		User user = userOptional.get();

		return user.getPosts();

	}
}
