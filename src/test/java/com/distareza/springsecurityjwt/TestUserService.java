package com.distareza.springsecurityjwt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.distareza.springsecurityjwt.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class TestUserService {

	@Autowired
	private UserService userService;
	
	@Test
	public void testInitUser() throws Exception {
		userService.initUser();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonText = objectMapper.writeValueAsString(userService.getAllUser());
		System.out.println(jsonText);
		
		assertTrue(true);
	};

	@Test
	public void testFindUserByName() throws Exception {
		
		userService.initUser();
		System.out.println(  userService.findtUser("admin") );
		assertTrue(true);
		
	}
	
}
