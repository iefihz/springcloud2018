package com.iefihz.cloud.controller;

import com.iefihz.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    //可以通过RestTemplate消费服务
    @Autowired
    private RestTemplate restTemplate;

    /**
     * hystrix回调方法，默认1秒超时，回调策略有两种：THREAD(默认)，SEMAPHORE，建议默认即可，也就是不用加commandProperties属性，
     * 若在此类上使用了@SessionScope, @RequestScope等注解，导致有运行时异常的出现，可以尝试修改策略
     * @param uid
     * @return
     */
    @GetMapping("/user/{uid:[0-9]+}")
    @HystrixCommand(fallbackMethod = "findByUidFallBack")
//    @HystrixCommand(fallbackMethod = "findByUidFallBack", commandProperties = @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"))
    public User findByUid(@PathVariable("uid") Long uid) {
        //cloud-provider-user是spring.application.name设置的内容，虚拟主机名
        User user = this.restTemplate.getForObject("http://cloud-provider-user/user/" + uid, User.class);
        return user;
    }

    private User findByUidFallBack(@PathVariable("uid") Long uid) {
        User user = new User();
        user.setId(666L);
        user.setUsername("小红");
        return user;
    }
}
