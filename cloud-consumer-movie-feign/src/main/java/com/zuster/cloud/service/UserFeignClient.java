package com.zuster.cloud.service;

import com.zuster.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("cloud-provider-user")
public interface UserFeignClient{
    // @GetMapping不支持
    // @PathVariable必须设置value
    @RequestMapping(value = "simple/{id}",method = {RequestMethod.GET})
    User findById(@PathVariable("id") Long id);
//    @RequestMapping(value = "simple",method = {RequestMethod.POST})
//    User postUser(@RequestBody User user);
    // 若参数是对象，即使使用了GET方法，Feign依然会以POST方法进行发送
    @RequestMapping(value = "simple",method = {RequestMethod.GET})
    User postUser(@RequestBody User user);
}