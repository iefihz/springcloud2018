package com.iefihz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 把config server注册到注册中心
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigServerToEurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerToEurekaApp.class, args);
    }
}
