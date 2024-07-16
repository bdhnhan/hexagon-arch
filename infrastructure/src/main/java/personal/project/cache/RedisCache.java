package personal.project.cache;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.project.domain.OrderDomain;
import personal.project.utils.GsonUtils;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisCache {

    @Autowired
    private RedissonClient redissonClient;

    public void saveOrder(OrderDomain orderDomain) {
        redissonClient.getBucket(getOrderKey(orderDomain.getId(), orderDomain.getUserId()))
                .set(GsonUtils.toJsonString(orderDomain), 10, TimeUnit.SECONDS);
        log.info("Save order : {}", orderDomain);
    }

    public OrderDomain getOrder(String orderId, String userId) {
        RBucket<String> bucket = redissonClient.getBucket(getOrderKey(orderId, userId));
        return GsonUtils.fromJsonString(bucket.get(), OrderDomain.class, new OrderDomain());
    }

    private String getOrderKey(String orderId, String userId) {
        return String.format("%s|%s", orderId, userId);
    }

}
