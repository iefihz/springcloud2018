package com.iefihz.cloud.feign;

import com.iefihz.cloud.config.FeignConfiguration;
import com.iefihz.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 这里使用FeignConfiguration.class作为FeignClient配置的原因：在FeignClient类上
 * 使用了@RequestMapping注解，在SpringMVC中，会加载使用了@Controller和@RequestMapping的类，
 * 而Feign也会加载使用了@FeignClient的类，这里SpringMVC和Feign加载FeignClient产生了冲突
 */
@RequestMapping("/user")
@FeignClient(name = "cloud-provider-user", fallback = UserFeignClientHystrixFallBack.class, configuration = FeignConfiguration.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/testGet", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    User testGet(@RequestBody User user);

}
