package com.distareza.springsecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distareza.springsecurityjwt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String userName);
	
}
