package com.example.demoLdap.repositories.ldap2;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.data.ldap.repository.Query;

import com.example.demoLdap.beans.User;

public interface UserRepository2 extends LdapRepository<User> {

	@Query("(uid={0})")
	User findByUid(String uid);
	
}
