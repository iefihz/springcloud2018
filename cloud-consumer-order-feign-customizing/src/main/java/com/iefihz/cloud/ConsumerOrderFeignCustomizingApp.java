package com.iefihz.cloud;

import com.iefihz.cloud.annotation.ExcludeComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * 这里使用的@ComponentScan和ribbon模块里面定制负载均衡规则配置的原理相同，
 * 不能扫描使用了@ExcludeComponentScan的配置类CustomizingConfiguration.class
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeComponentScan.class))
public class ConsumerOrderFeignCustomizingApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderFeignCustomizingApp.class, args);
    }
}
