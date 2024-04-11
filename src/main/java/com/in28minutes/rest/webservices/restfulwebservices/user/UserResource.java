package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	private UserDaoService service;
	
	@Autowired
	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public User retrieveUser(@PathVariable int id) {
		return service.findOne(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteById(id) ? "User deleted" : "User with id:"+id+" does not exist";  
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
							.path("{/id}")
							.buildAndExpand(savedUser.getId())
							.toUri();
		return ResponseEntity.created(location).build();
	}
}
