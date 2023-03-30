package com.iefihz.cloud.controller;

import com.iefihz.cloud.entity.User;
import com.iefihz.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{uid:[0-9]+}")
    public User findByUid(@PathVariable("uid") Long uid) {
        User user = userFeignClient.findById(uid);
        return user;
    }

    @GetMapping("/testGet")
    public User testGet() {
        User user = new User();
        user.setId(5L);
        user.setUsername("小明");
        user.setAge((short) 12);
        return userFeignClient.testGet(user);
    }
}
