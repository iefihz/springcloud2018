package com.iefihz.cloud.config;

import com.iefihz.cloud.annotation.ExcludeComponentScan;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 定制Feign契约的配置
 */
@Component
@ExcludeComponentScan
public class CustomizingConfiguration {

//    这个配置会后需要在FeignClient的抽象方法上面使用@RequestLine
//    @Bean
//    public Contract feignContract() {
//        return new feign.Contract.Default();
//    }

    //配置日志级别
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
