package com.example.demoLdap.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.ldap.LdapProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
@EnableLdapRepositories("com.example.demoLdap.repositories.ldap1")
public class LdapConfiguration {

	
	@Bean(name="contextSource1")
    public LdapContextSource contextSourceTarget(LdapProperties ldapProperties) {
        LdapContextSource source = new LdapContextSource();

        source.setUserDn("uid=admin,ou=system");
        source.setPassword("password");
        source.setBase("dc=example,dc=com");
        source.setUrls(new String[] {"ldap://localhost:10389"});
        
        return source;
    }

    @Bean
    public LdapTemplate ldapTemplate(@Qualifier("contextSource1") LdapContextSource contextSource){
        return new LdapTemplate(contextSource);
    }
	
	
}
