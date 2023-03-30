package com.iefihz.cloud.feign;

import com.iefihz.cloud.config.CustomizingConfiguration;
import com.iefihz.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 由于定制的配置方式和原本的方式不一样，这里的RequestLine的访问路径需要写全路径，
 * 区别于原来接口上RequestMapping的value和方法上RequestMapping的value相拼接组成的路径
 */
@RequestMapping("/user")
@FeignClient(value = "cloud-provider-user", configuration = CustomizingConfiguration.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
//    @RequestLine("GET /user/{id}")
//    User findById(@Param("id") Long id);

    @RequestMapping(value = "/testGet", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    User testGet(@RequestBody User user);
//    @RequestLine("GET /user/testGet")
//    User testGet(User user);
}
