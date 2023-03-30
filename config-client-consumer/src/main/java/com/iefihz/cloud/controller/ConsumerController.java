package com.iefihz.cloud.controller;

import com.iefihz.cloud.feign.ConsumerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Value("${uname}")
    private String uname;

    @Value("${pwd}")
    private String pwd;

    @Autowired
    private ConsumerFeignClient consumerFeignClient;

    @GetMapping("/get")
    public String get() {
        return "From consumer ===> uname: " + uname + ", pwd: " + pwd;
    }

    @GetMapping("/testFeign")
    public String testFeign() {
        return consumerFeignClient.get();
    }

}
