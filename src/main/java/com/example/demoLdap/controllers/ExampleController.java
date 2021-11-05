package com.example.demoLdap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoLdap.beans.User;
import com.example.demoLdap.repositories.UserRepository;

@RestController
public class ExampleController {

	@Autowired
	private UserRepository userRespository;
	
	@GetMapping("/api/hello")
	public ResponseEntity<User> searchUser(@RequestParam("uid") String uid) {
		User user = userRespository.findByUid(uid != null ? uid : "jwick");
		
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
}
