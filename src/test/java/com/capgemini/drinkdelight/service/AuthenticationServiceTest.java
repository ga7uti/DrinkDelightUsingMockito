package com.capgemini.drinkdelight.service;

import com.capgemini.drinkdelight.entity.User;
import com.capgemini.drinkdelight.repository.AuthenticationRepository;
import com.capgemini.drinkdelight.services.AuthenticationService;
import com.capgemini.drinkdelight.services.AuthenticationServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthenticationServiceTest {

	@Mock
	AuthenticationRepository authRepoMock;

	AuthenticationService authService;


	@BeforeEach
	void setup(){
		authService = new AuthenticationServiceImp(authRepoMock);
	}

	@Test
	void testLoginWhenUserPresent() {	
		String username = "Gautam";
		String password = "Mishra";
		when(authRepoMock.login(username, password)).thenReturn(new User("Gautam","gauti@gmail.com","gauti","7042312883"));	
		User result = authService.login(username, password);
		assertNotNull(result);
	}
	
	@Test
	void testLoginWhenUserNotPresent() {	
		String username = "Gautam";
		String password = "Mishra";
		when(authRepoMock.login(username, password)).thenReturn(null);
		User result = authService.login(username, password);
		assertNull(result);
	}
	
	@Test
	void testLoginWhenWrongPassword() {	
		String username = "Gautam";
		String password = "Mishra";
		when(authRepoMock.login(username, password)).thenReturn(null);
		User result = authService.login(username, password);
		assertNull(result);
	}
	
	@Test
	void testRegisterWhenUserNotPresent() {	
		User user = new User("Gautam","gauti@gmail.com","gauti","7042312883");
		when(authRepoMock.register(user)).thenReturn(true);
		boolean result = authService.register(user);
		assertTrue(result);
	}
	
	@Test
	void testRegisterWhenUserAlreadyPresent() {	
		User user = new User("Gautam","gauti@gmail.com","gauti","7042312883");
		when(authRepoMock.register(user)).thenReturn(false);
		boolean result = authService.register(user);
		assertFalse(result);
	}
	
	@Test
	void testForgotPasswordWhenUserPresent() {	
		String email = "gauti@gmail.com";
		String newPassword = "@Qwerty123";
		when(authRepoMock.updatePassword(email,newPassword)).thenReturn(true);
		boolean result = authService.updatePassword(email, newPassword);
		assertTrue(result);
	}
	
	
	@Test
	void testForgotPasswordWhenUserNotPresent() {	
		String email = "gauti@gmail.com";
		String newPassword = "@Qwerty123";
		when(authRepoMock.updatePassword(email,newPassword)).thenReturn(false);
		boolean result = authService.updatePassword(email, newPassword);
		assertFalse(result);
	}
}
