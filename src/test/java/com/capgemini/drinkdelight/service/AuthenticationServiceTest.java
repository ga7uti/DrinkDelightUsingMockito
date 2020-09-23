package com.capgemini.drinkdelight.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.drinkdelight.entity.User;
import com.capgemini.drinkdelight.repository.AuthenticationRepository;
import com.capgemini.drinkdelight.services.AuthenticationService;
import com.capgemini.drinkdelight.services.AuthenticationServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationServiceTest {
	
	@Test
	void testLoginWhenUserPresent() {	
		AuthenticationRepository authRepoMock = mock(AuthenticationRepository.class);
		String username = "Gautam";
		String password = "Mishra";
		when(authRepoMock.login(username, password)).thenReturn(new User("Gautam","gauti@gmail.com","gauti","7042312883"));	
		AuthenticationService authService = new AuthenticationServiceImp(authRepoMock);
		User result = authService.login(username, password);
		assertNotNull(result);
	}
	
	@Test
	void testLoginWhenUserNotPresent() {	
		AuthenticationRepository authRepoMock = mock(AuthenticationRepository.class);
		String username = "Gautam";
		String password = "Mishra";
		when(authRepoMock.login(username, password)).thenReturn(null);
		AuthenticationService authService = new AuthenticationServiceImp(authRepoMock);
		User result = authService.login(username, password);
		assertEquals(null, result);
	}
	
	@Test
	void testLoginWhenWrongPassword() {	
		AuthenticationRepository authRepoMock = mock(AuthenticationRepository.class);
		String username = "Gautam";
		String password = "Mishra";
		when(authRepoMock.login(username, password)).thenReturn(null);
		AuthenticationService authService = new AuthenticationServiceImp(authRepoMock);
		User result = authService.login(username, password);
		assertEquals(null, result);
	}
	
	@Test
	void testRegisterWhenUserNotPresent() {	
		User user = new User("Gautam","gauti@gmail.com","gauti","7042312883");
		AuthenticationRepository authRepoMock = mock(AuthenticationRepository.class);
		when(authRepoMock.register(user)).thenReturn(true);
		AuthenticationService authService = new AuthenticationServiceImp(authRepoMock);
		boolean result = authService.register(user);
		assertEquals(true, result);
	}
	
	@Test
	void testRegisterWhenUserAlreadyPresent() {	
		User user = new User("Gautam","gauti@gmail.com","gauti","7042312883");
		AuthenticationRepository authRepoMock = mock(AuthenticationRepository.class);
		when(authRepoMock.register(user)).thenReturn(false);
		AuthenticationService authService = new AuthenticationServiceImp(authRepoMock);
		boolean result = authService.register(user);
		assertEquals(false, result);
	}
	
	@Test
	void testForgotPasswordWhenUserPresent() {	
		String email = "gauti@gmail.com";
		String newPassword = "@Qwerty123";
		AuthenticationRepository authRepoMock = mock(AuthenticationRepository.class);
		when(authRepoMock.updatePassword(email,newPassword)).thenReturn(true);
		AuthenticationService authService = new AuthenticationServiceImp(authRepoMock);
		boolean result = authService.updatePassword(email, newPassword);
		assertEquals(true, result);
	}
	
	
	@Test
	void testForgotPasswordWhenUserNotPresent() {	
		String email = "gauti@gmail.com";
		String newPassword = "@Qwerty123";
		AuthenticationRepository authRepoMock = mock(AuthenticationRepository.class);
		when(authRepoMock.updatePassword(email,newPassword)).thenReturn(false);
		AuthenticationService authService = new AuthenticationServiceImp(authRepoMock);
		boolean result = authService.updatePassword(email, newPassword);
		assertEquals(false, result);
	}
}
