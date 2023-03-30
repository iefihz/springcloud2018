package com.iefihz.cloud.controller;

import com.iefihz.cloud.entity.User;
import com.iefihz.cloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/testGet")
    User testGet(@RequestBody User user) {
        user.setAge((short) 23);
        return user;
    }
}
