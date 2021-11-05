package com.example.demoLdap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoLdap.beans.User;
import com.example.demoLdap.service.UserLookupService;

@RestController
public class ExampleController {

	@Autowired
	private UserLookupService userLookupService;
	
	@GetMapping("/api/hello")
	public ResponseEntity<User> searchUser(@RequestParam("uid") String uid) {
		User user = userLookupService.searchUserByUid(uid != null ? uid : "jwick");
		
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
}
