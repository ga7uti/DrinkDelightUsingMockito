package com.capgemini.drinkdelight.repository;

import com.capgemini.drinkdelight.entity.User;


public interface AuthenticationRepository {
	User login(String username, String password);
	boolean register(User newUser);
	boolean updatePassword(String email , String newPassword);
}
