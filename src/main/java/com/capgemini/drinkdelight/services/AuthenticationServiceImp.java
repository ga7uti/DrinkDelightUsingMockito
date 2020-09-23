package com.capgemini.drinkdelight.services;

import com.capgemini.drinkdelight.entity.User;
import com.capgemini.drinkdelight.repository.AuthenticationRepository;

public class AuthenticationServiceImp implements AuthenticationService {

	private AuthenticationRepository authRepo;
	
	
	public AuthenticationServiceImp(AuthenticationRepository authRepo) {
		super();
		this.authRepo = authRepo;
	}

	@Override
	public User login(String username, String password) {
		return authRepo.login(username, password);
	}

	@Override
	public boolean register(User newUser) {
		return authRepo.register(newUser);
	}

	@Override
	public boolean updatePassword(String email, String newPassword) {
		return authRepo.updatePassword(email, newPassword);
	}

}
