package com.iefihz.cloud;

import com.iefihz.cloud.filter.PreZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulFilterApp {

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulFilterApp.class, args);
    }

    @Bean
    public PreZuulFilter preZuulFilter() {
        return new PreZuulFilter();
    }
}
