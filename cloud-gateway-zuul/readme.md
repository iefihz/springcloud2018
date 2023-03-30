```
使用Zuul作为Gateway，可以做反向代理服务（服务器代理）：
访问路径：zuul的url+"/"+服务的VIP(虚拟ip)+具体服务uri
可以通过如下配置修改VIP和不用代理的微服务:
#这里的/*和/**区别于匹配一层或者任意层路径
#zuul:
#  routes:
#    cloud-provider-user: /userProxy/**
#  ignored-services: cloud-consumer-order
#或者(xxx是唯一的即可，可负载均衡)：
#zuul:
#    routes:
#        xxx:
#            path: /userProxy/**
#            serviceId: cloud-provider-user
#或者(这种方式不能负载均衡)：
#zuul:
#    routes:
#        xxx:
#            path: /userProxy/**
#            url: 服务提供者的url

#可以配置prefix以及strip-prefix(默认true)，两者可以针对某个路由也可以全局使用，
#strip-prefix设为false的话，从路由转发到微服务的时候会去掉serviceId，应用于已经设定了
#context-path，但是在访问首页时不想要serviceId

#也可通过zuul上传文件，大文件需要加/zuul前缀绕过dispatcherServlet
```