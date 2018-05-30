package com.zuster.cloud.controller;

import com.zuster.cloud.entity.User;
import com.zuster.cloud.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MovieController {
	@Autowired
	UserFeignClient userFeignClient;
	@GetMapping("movie/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}
	@GetMapping("movie")
	public User postUser(){
		User user = new User();
		user.setAge((short)17);
		user.setBalance(new BigDecimal(900));
		user.setId(101010L);
		user.setName("LIMING");
		user.setUsername("lalala");
		return userFeignClient.postUser(user);
	}
}
