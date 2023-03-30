```
配置eureka的高可用注意：
1.服务注册到EurekaServer时，尽量注册到1个以上的节点，避免服务节点宕机导致注册失败。

##################################################
i.可以通过${spring.cloud.client.ipAddress}获取客户端ip，可做更好的展示
ii.使用RestTemplate进行远程调用的时候，若返回的对象是比如：List<User>，需要在接收的时候使用User[].class，而非List.class
```