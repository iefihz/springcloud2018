```
springcloud-config(config-*模块)相关注意事项：

git仓库配置文件发生改变后，进行手动刷新配置文件：
1. 导入spring-boot-starter-actuator
2. 在使用了配置文件的类上使用@RefreshScope，尽量避免与@Configuration使用，可能会有其它异象
3. 使用curl: curl -X POST http://{host}:{port}/refresh进行手动刷新（也就是使用post访问http://{host}:{port}/refresh）
如：使用POST请求访问http://localhost:9101/refresh
---------------------------------------------------------
1. 可以通过{application}设置uri的通配符来控制一个git仓库对应一个微服务
2. 当前匹配可以通过http://localhost:9000/{lable}/{application}-{profile}.yml加载配置文件，
如：http://localhost:9000/main/config-client-consumer-dev.yml，更多匹配模式上spring官网查看
---------------------------------------------------------
测试对称加密：
1. 设置密钥，encrypt.key: my_encrypt_key
2. 加密：curl 192.168.199.249:9000/encrypt -d mysecret
3. 解密：curl 192.168.199.249:9000/decrypt -d *********
4. 在加密串前加上：{cipher}可以实现获取数据时自动解密，*.yml要加单引号，
*.properties的配置文件不用加单引号，否则无法自动解密
---------------------------------------------------------
测试非对称加密：
1. 生成jks文件命令：
keytool -genkeypair -alias mytestkey -keyalg RSA
-dname "CN=Web Server,OU=Unit,O=Organization,L=City,S=State,C=US"
-keypass changeme -keystore server.jks -storepass letmein
2. 加密：curl 192.168.199.249:9000/encrypt -d mysecret
3. 解密：curl 192.168.199.249:9000/decrypt -d *********
4. 在加密串前加上：{cipher}可以实现获取数据时自动解密，*.yml要加单引号，
*.properties的配置文件不用加单引号，否则无法自动解密
```
