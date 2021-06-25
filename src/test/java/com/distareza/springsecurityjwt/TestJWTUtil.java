package com.distareza.springsecurityjwt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.distareza.springsecurityjwt.util.JWTUtil;

@SpringBootTest
public class TestJWTUtil {

	@Autowired
	private JWTUtil jwtUtil;
	
	@Test
	public void generateToken() {
		System.out.println(jwtUtil.generateToken("distareza"));
		assertTrue(true);
	}
	
}
