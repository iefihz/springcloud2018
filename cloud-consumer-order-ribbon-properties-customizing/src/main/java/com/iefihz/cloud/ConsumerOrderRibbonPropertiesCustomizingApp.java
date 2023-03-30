package com.iefihz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 使用配置文件的方式配置RibbonClient策略，
 * 优先级：使用配置文件配置>使用自定义配置>默认配置(@LoadBalanced)
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerOrderRibbonPropertiesCustomizingApp {

    @Bean
    @LoadBalanced   //使用Ribbon进行负载均衡，spring-cloud-starter-eureka已经引入了ribbon的依赖
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderRibbonPropertiesCustomizingApp.class, args);
    }
}
