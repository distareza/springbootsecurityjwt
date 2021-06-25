package com.distareza.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.distareza.springsecurityjwt.entity.AuthRequest;
import com.distareza.springsecurityjwt.util.JWTUtil;

@RestController
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception { 
		
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authRequest.getUserName(), 
						authRequest.getPassword())
		);
		} catch (Exception ex) {
			throw new Exception("Invalid username/password");
		}
		
		return jwtUtil.generateToken(authRequest.getUserName());
	}
}
