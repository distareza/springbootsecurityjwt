package com.distareza.springsecurityjwt.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distareza.springsecurityjwt.entity.User;
import com.distareza.springsecurityjwt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void initUser() {
		
		List<User> users = Stream.of(
					new User( 1, "distareza", "password", "distareza@gmail.com"),
					new User( 2, "admin", "nimda", "admin@localhost.com"),
					new User( 3, "guest", "whoami", "guess@localhost.com")
				).collect(Collectors.toList());
		userRepository.saveAll(users);
		
	}
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public User findtUser(String userName) {
		return userRepository.findByUserName(userName);
	}

}
