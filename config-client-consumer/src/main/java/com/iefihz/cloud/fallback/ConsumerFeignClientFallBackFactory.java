package com.iefihz.cloud.fallback;

import com.iefihz.cloud.feign.ConsumerFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 使用FallbackFactory来进行短路机制，同时支持Hystrix的日志输出，不能与fallback共用
 */
@Component
public class ConsumerFeignClientFallBackFactory implements FallbackFactory<ConsumerFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerFeignClientFallBackFactory.class);

    @Override
    public ConsumerFeignClient create(Throwable throwable) {

        //在这里可以打印日志，使用占位符比使用字符串相连效率高
//        LOGGER.info("###############################\r\nfallback reason was: {}", throwable.getMessage());

        return new AbstractConsumerFeignClient() {
            @Override
            public String get() {
                return "网络出问题，走的是FallBack";
            }
        };
    }
}
