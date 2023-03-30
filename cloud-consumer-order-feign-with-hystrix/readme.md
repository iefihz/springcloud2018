```
禁用所有FeignClient对Hystrix的支持：
//    feign.hystrix.enabled: false

禁用某个FeignClient对Hystrix的支持：
//    @Bean
//    @Scope("prototype")
//    public Feign.Builder feignBuilder() {
//        return Feign.builder();
//    }

Feign默认打开hystrix，这里引入spring-cloud-starter-hystrix以及在启动类上使用注解@EnableCircuitBreaker
是为了监控hystrix
```