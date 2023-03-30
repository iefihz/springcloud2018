package com.iefihz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulApp {

    /**
     * 表示serviceId “myusers-v1” 将会被映射到 “/v1/myusers/“
     * @return PatternServiceRouteMapper
     */
//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper() {
//        return new PatternServiceRouteMapper(
//                "(?<name>^.+)-(?<version>v.+$)",
//                "${version}/${name}");
//    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulApp.class, args);
    }
}
