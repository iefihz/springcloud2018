package com.iefihz.cloud.config;

import com.iefihz.cloud.annotation.ExcludeComponentScan;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 随机策略配置类，类似这种自定义配置的策略，需要放在@ComponentScanner扫描不到的地方，
 * 或者另外写一个注解在组件扫描的类上排除自定义规则的配置类，否则被扫描到的策略配置会应用到所有的RibbonClient上
 */
@Configuration
@ExcludeComponentScan
public class ServiceRandomRule {

    @Autowired
    IClientConfig config;

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RandomRule();
    }

}
