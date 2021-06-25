package com.distareza.springsecurityjwt.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/")
	public String welcome() {
		return "Welcome";
	}

	@GetMapping("/ping")
	public String ping() {
		return "OK";
	}

	@GetMapping("/info")
	public Map<String, Object> getInfo() {
		Map<String, Object> map = new HashMap<>();
		map.put("status", "OK");
		map.put("date", new Date());
		
		return map;
	}
}
