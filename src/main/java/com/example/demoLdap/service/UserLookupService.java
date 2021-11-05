package com.example.demoLdap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoLdap.beans.User;
import com.example.demoLdap.repositories.ldap1.UserRepository;
import com.example.demoLdap.repositories.ldap2.UserRepository2;

@Service
public class UserLookupService {

	@Autowired
	private UserRepository userRepository1;
	
	@Autowired
	private UserRepository2 userRepository2;
	
	
	public User searchUserByUid(String uid) {
		User user = userRepository1.findByUid(uid);
		
		if(user == null) {
			user = userRepository2.findByUid(uid);
		}
		
		return user;
    }
	
	
}
