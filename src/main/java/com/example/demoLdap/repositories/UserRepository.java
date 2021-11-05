package com.example.demoLdap.repositories;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.data.ldap.repository.Query;

import com.example.demoLdap.beans.User;

public interface UserRepository extends LdapRepository<User> {

	@Query("(uid={0})")
	User findByUid(String uid);
	
}
