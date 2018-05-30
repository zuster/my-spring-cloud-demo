package com.zuster.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.zuster.cloud.entity.User;
import com.zuster.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EurekaClient eurekaClient;
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@GetMapping("simple/{id}")
	public User findById(@PathVariable Long id) {
		return this.userRepository.getOne(id);
	}
	@PostMapping("simple")
	public User postUser(@RequestBody User user){
		return user;
	}
	@GetMapping("eureka-instance")
	public String serviceUrl(){
        InstanceInfo instanceInfo = this.eurekaClient.getNextServerFromEureka("CLOUD-PROVIDER-USER",false);
        return instanceInfo.getHomePageUrl();
    }

    @GetMapping("instance-info")
    public ServiceInstance showInfo(){
	    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
	    return localServiceInstance;
    }
}
