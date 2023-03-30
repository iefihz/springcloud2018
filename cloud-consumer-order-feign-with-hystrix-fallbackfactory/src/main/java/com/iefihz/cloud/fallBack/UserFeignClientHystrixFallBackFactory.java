package com.iefihz.cloud.fallBack;

import com.iefihz.cloud.entity.User;
import com.iefihz.cloud.feign.UserFeignClient;
import com.iefihz.cloud.feign.UserFeignClientWithFactory;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 使用FallbackFactory来进行短路机制，同时支持Hystrix的日志输出，不能与fallback共用
 */
@Component
public class UserFeignClientHystrixFallBackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFeignClientHystrixFallBackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {

        //在这里可以打印日志，使用占位符比使用字符串相连效率高
        LOGGER.info("###############################\r\nfallback reason was: {}", throwable.getMessage());

        return new UserFeignClientWithFactory() {
            @Override
            public User findById(Long id) {
                User user = new User();
                user.setId(333L);
                return user;
            }

            @Override
            public User testGet(User user) {
                User user1 = new User();
                user1.setId(666L);
                return user1;
            }
        };
    }
}
