package com.iefihz.cloud.controller;

import com.iefihz.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    //可以通过LoadBalancerClient获取服务的实例
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{uid:[0-9]+}")
    public User findByUid(@PathVariable("uid") Long uid) {
        //cloud-provider-user是spring.application.name设置的内容，虚拟主机名
        User user = this.restTemplate.getForObject("http://cloud-provider-user/user/" + uid, User.class);
        return user;
    }

    /**
     * 测试前提：各生成2个cloud-provider-user和cloud-provider-user2，
     * 这里cloud-provider-user使用轮询策略，另外一个使用RandomRule
     */
    @GetMapping("/printRibbonRules")
    public void printRibbonRules() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("cloud-provider-user");
        ServiceInstance serviceInstance2 = loadBalancerClient.choose("cloud-provider-user2");
        System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort());
        System.out.println(serviceInstance2.getHost() + ":" + serviceInstance2.getPort());
    }
}
