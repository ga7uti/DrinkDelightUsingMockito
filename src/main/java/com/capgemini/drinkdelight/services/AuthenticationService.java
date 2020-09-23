package com.capgemini.drinkdelight.services;

import com.capgemini.drinkdelight.entity.User;

public interface AuthenticationService {
	User login(String username, String password);
	boolean register(User newUser);
	boolean updatePassword(String email , String newPassword);
}
