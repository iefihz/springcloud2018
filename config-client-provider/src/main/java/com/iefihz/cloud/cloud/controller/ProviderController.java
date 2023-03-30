package com.iefihz.cloud.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Value("${uname}")
    private String uname;

    @Value("${pwd}")
    private String pwd;

    @GetMapping("/get")
    public String get() {
        return "From provider ===> uname: " + uname + ", pwd: " + pwd;
    }

}
