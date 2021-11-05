package com.example.demoLdap.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.ldap.LdapProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
@EnableLdapRepositories(basePackages="com.example.demoLdap.repositories.ldap2", ldapTemplateRef="ldapTemplate2")
public class LdapConfiguration2 {

	
	@Bean(name="contextSource2")
    public LdapContextSource contextSourceTarget(LdapProperties ldapProperties) {
        LdapContextSource source = new LdapContextSource();

        source.setUserDn("uid=admin,ou=system");
        source.setPassword("password");
        source.setBase("dc=example,dc=com");
        source.setUrls(new String[] {"ldap://localhost:10390"});
        
        return source;
    }

    @Bean(name="ldapTemplate2")
    public LdapTemplate ldapTemplate(@Qualifier("contextSource2") LdapContextSource contextSource){
        return new LdapTemplate(contextSource);
    }
	
	
}
