package com.initiallyrics.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public Boolean authenticate(String name, String password) {
		boolean isValidName = name.equalsIgnoreCase("abdul");
		boolean isValidPassword = password.equalsIgnoreCase("pass");
		return isValidName && isValidPassword;
	}
}
