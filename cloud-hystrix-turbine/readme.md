```
需要注册到eureka才能实现集群监控
访问dashboard路径：http://localhost:8762/hystrix
然后在上面访问http://localhost:8763/turbine.stream?cluster=CLOUD-CONSUMER-ORDER
若配置的cluster为default，则不用加参数cluster
#配置如下：
#turbine:
#  aggregator:
#    clusterConfig: CLOUD-CONSUMER-ORDER
#  appConfig: cloud-consumer-order
#
#配置多个（也可以像上面配置多个用逗号分隔）：
#turbine:
#  aggregator:
#    clusterConfig: default
#  appConfig: xxx,yyy
#  clusterNameExpression: "'default'" 或者 new String("default")

#若要配置某个模块的server.context-path，那么为了turbine能够正确收集信息，需要配置:
#方法一：
#在该模块下配置
#server.context-path: /xxx
#eureka.instance.home-page-url-path: /xxx
#在turbine模块配置
#turbine.instanceUrlSuffix.CLOUD-CONSUMER-ORDER: /xxx/hystrix.stream
#方法二：
#在该模块下配置，不用修改turbine模块配置，也就是访问端口和管理端口分离：
#server.context-path: /xxx
#management.port: xxx和eureka.instance.metadata-map.management.port: xxx
```