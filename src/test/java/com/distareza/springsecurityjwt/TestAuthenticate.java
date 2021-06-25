package com.distareza.springsecurityjwt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * to test this unit class
 * make sure the springboot application is up and running
 */

@SpringBootTest
public class TestAuthenticate {

	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testGenerateToken() {
		
		Map<String, Object> map = new HashMap<>();
		map.put("userName", "admin");
		map.put("password", "nimda");
		
		System.out.println("Generate Token");
		String token = restTemplate.postForObject("http://localhost:9192/authenticate", map, String.class);
		
		System.out.println(token);
		System.out.println("done");
		assertTrue(true);
	}
	
	@Test
	public void testAccessPingSite() {
		String output = restTemplate.getForObject("http://localhost:9192/ping", String.class);
		System.out.println(output);
		
		assertTrue(true);
	}
	
	@Test
	public void testAccessSecureSite() {
		
		String token ;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("userName", "admin");
			map.put("password", "nimda");
			token = restTemplate.postForObject("http://localhost:9192/authenticate", map, String.class);
			System.out.println("Authenticate OK");
		} catch (Exception ex) {
			System.err.println("Authentication Failed");
			System.err.println(ex.toString());
			assertTrue(false);
			return;
		}
		
		System.out.format("Get Token : %s\n", token);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<Object> entity = new HttpEntity<>(headers);

		String url = "http://localhost:9192/info";
		
		ResponseEntity<String> htmlPage = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		
		
		System.out.println(htmlPage.getBody());
		
		assertTrue(true);
	}
	

}
