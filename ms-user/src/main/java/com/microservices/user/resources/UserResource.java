package com.microservices.user.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.user.entities.User;
import com.microservices.user.repositories.UserRepository;


@RestController
@RequestMapping(value = "/users")
public class UserResource {
	

	@Autowired
	private UserRepository repository;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User objUser = repository.findById(id).get();
		return ResponseEntity.ok(objUser);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findById(@RequestParam String email){
		User objUser = repository.findByEmail(email);
		return ResponseEntity.ok(objUser);
	}
}
