package com.iefihz.cloud;

import com.iefihz.cloud.annotation.ExcludeComponentScan;
import com.iefihz.cloud.config.ServiceRandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-provider-user2", configuration = ServiceRandomRule.class)
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeComponentScan.class))    //目的不让@ComponentScan扫描@ExcludeComponentScan标识的类
public class ConsumerOrderRibbonApp {

    @Bean
    @LoadBalanced   //使用Ribbon进行负载均衡，spring-cloud-starter-eureka已经引入了ribbon的依赖
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderRibbonApp.class, args);
    }
}
