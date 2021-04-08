package org.simplilearn.workshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	protected void configureUser(AuthenticationManagerBuilder authentication) throws Exception{
		
		authentication.inMemoryAuthentication()
		.withUser("mahendra").password("{noop}simplilearn").roles("USER")
		.and()
		.withUser("simplilearn").password("{noop}simplilearn").roles("ADMIN");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest().fullyAuthenticated()
		.and()
		.httpBasic();
	}

}
