package com.initiallyrics.myfirstwebapp.security;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {

		UserDetails userDetails1 = createNewUser("abdul", "java");
		UserDetails userDetails2 = createNewUser("matania", "java");

		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(username).password(password)
				.roles("USER", "ADMIN").build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//All URLs are protected
		//A login form is shown for unauthorized requests
		//CSRF disable
		//Frames
		
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			
			http.authorizeHttpRequests(   
					auth -> auth.anyRequest().authenticated());  //any authorized req needs to be authenticated
			http.formLogin(withDefaults()); //any unauthorized req needs to go to login page
			
			http.csrf().disable();  //disabling CSRF
			http.headers().frameOptions().disable(); //disabling frames bcos H2 DB needs frames
			
			return http.build();
		}

}
