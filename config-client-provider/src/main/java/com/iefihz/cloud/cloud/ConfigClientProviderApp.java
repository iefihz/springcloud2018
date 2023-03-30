package com.iefihz.cloud.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableCircuitBreaker
//@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientProviderApp.class, args);
    }
}
