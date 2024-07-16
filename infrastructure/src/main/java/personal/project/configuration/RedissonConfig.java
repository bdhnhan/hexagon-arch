package personal.project.configuration;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient(RedissonProperties redissonProperties) {
        log.info("redissonProperties: {}", redissonProperties);
        Config config = new Config();
        config.useSingleServer().setAddress(redissonProperties.getAddress());
        return Redisson.create(config);
    }
}
