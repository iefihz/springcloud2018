package com.iefihz.cloud.controller;

import com.iefihz.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{uid:[0-9]+}")
    public User findByUid(@PathVariable("uid") Long uid) {
        User user = restTemplate.getForObject("http://127.0.0.1:7000/user/" + uid, User.class);
        return user;
    }
}
