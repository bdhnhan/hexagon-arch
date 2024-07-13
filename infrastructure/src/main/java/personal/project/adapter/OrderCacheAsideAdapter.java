package personal.project.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import personal.project.cache.RedisCache;
import personal.project.domain.OrderDomain;
import personal.project.port.out.OrderStoragePort;

import java.util.Objects;

@Primary
@Service
public class OrderCacheAsideAdapter implements OrderStoragePort {

    @Autowired
    private OrderPersistenceAdapter orderPersistenceAdapter;
    @Autowired
    private RedisCache redisCache;


    @Override
    public String storeOrder(OrderDomain orderDomain) {
        String orderId = orderPersistenceAdapter.storeOrder(orderDomain);
        if (Objects.nonNull(orderId)) {
            redisCache.saveOrder(orderDomain);
            return orderId;
        }
        return "Cache not support this method";
    }

    @Override
    public boolean existsOrder(String orderId, String userId) {
        OrderDomain orderDomain = redisCache.getOrder(orderId, userId);
        if (Objects.nonNull(orderDomain)) {
            return true;
        }
        return orderPersistenceAdapter.existsOrder(orderId, userId);
    }
}
