package com.iefihz.cloud.feign;

import com.iefihz.cloud.config.FeignConfiguration;
import com.iefihz.cloud.fallback.ConsumerFeignClientFallBackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 这里使用FeignConfiguration.class作为FeignClient配置的原因：在FeignClient类上
 * 使用了@RequestMapping注解，在SpringMVC中，会加载使用了@Controller和@RequestMapping的类，
 * 而Feign也会加载使用了@FeignClient的类，这里SpringMVC和Feign加载FeignClient产生了冲突
 */
@RequestMapping("/provider")
@FeignClient(
        name = "config-client-provider",
        fallbackFactory = ConsumerFeignClientFallBackFactory.class,
        configuration = FeignConfiguration.class)
public interface ConsumerFeignClient {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    String get();

}
