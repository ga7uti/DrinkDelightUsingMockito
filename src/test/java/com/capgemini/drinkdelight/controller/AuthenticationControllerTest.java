package com.capgemini.drinkdelight.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.capgemini.drinkdelight.services.AuthenticationService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class AuthenticationControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	AuthenticationService authServiceMock;
	
	@Test
	void login() {	
	}
	
	
	@Test
	void register() {
		
	}
	
	@Test
	void forgotPassword() {
		
	}
	
	@Test
	void updatePassword() {
		
	}
}
