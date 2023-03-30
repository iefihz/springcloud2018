注意要点：
1. FeignClient接口要与服务提供者的方法一致
2. 需要使用RequestMapping(value = "/xxx", method = RequestMethod.GET)，不能使用GetMapping("/xxx")
3. PathVariable, RequestParam要指定对应的value的值
4. 使用get请求时，但是参数是一个复杂类型：
在方法参数里面使用@RequestBody；
添加依赖信息compile 'io.github.openfeign:feign-httpclient:9.5.1'；
在@RequestMapping添加参数consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
7. 还可以对其请求压缩等进行配置，略