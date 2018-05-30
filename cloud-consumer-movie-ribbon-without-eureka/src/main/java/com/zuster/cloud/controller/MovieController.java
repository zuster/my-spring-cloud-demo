package com.zuster.cloud.controller;

import com.zuster.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@GetMapping("movie/{id}")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://CLOUD-PROVIDER-USER/simple/" + id, User.class);
	}

	@GetMapping("test")
	public String test(){
		ServiceInstance choose1 = this.loadBalancerClient.choose("cloud-provider-user");
//		ServiceInstance choose2 = this.loadBalancerClient.choose("cloud-provider-user-1");
		System.out.println(choose1.getHost()+":"+choose1.getPort()+":"+choose1.getServiceId());
//		System.out.println(choose2.getHost()+":"+choose2.getPort()+":"+choose2.getServiceId());
		return "Success";
	}
}
