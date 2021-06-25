package com.distareza.springsecurityjwt;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.distareza.springsecurityjwt.service.UserService;

@SpringBootApplication
public class SpringsecurityjwtApplication {

	@Autowired
	private UserService userService;
	
	
	@PostConstruct
	public void initUser() {
		userService.initUser();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityjwtApplication.class, args);
	}

}
