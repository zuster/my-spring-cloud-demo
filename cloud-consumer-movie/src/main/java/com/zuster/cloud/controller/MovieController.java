package com.zuster.cloud.controller;

import com.zuster.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController {
	@Autowired
	RestTemplate restTemplate;
	@Value("${user.userServicePath}")
	private String userServicePath;
	@GetMapping("movie/{id}")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject(this.userServicePath + id, User.class);
	}
}
