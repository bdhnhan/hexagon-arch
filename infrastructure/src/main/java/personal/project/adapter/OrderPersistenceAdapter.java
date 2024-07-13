package personal.project.adapter;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import personal.project.db.OrderRepository;
import personal.project.domain.OrderDomain;
import personal.project.port.out.OrderStoragePort;
import personal.project.db.entity.OrderEntity;

import java.sql.Timestamp;

@Component
@Slf4j
public class OrderPersistenceAdapter implements OrderStoragePort {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public String storeOrder(OrderDomain order) {
        order.setId(StringUtils.isEmpty(order.getId()) ? String.valueOf(System.currentTimeMillis()) : order.getId());

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setAmount(order.getAmount());
        orderEntity.setCreatedTime(new Timestamp(order.getCreatedTime()));
        orderEntity.setUserId(order.getUserId());
        orderEntity.setStatus(OrderEntity.OrderStatusEnum.valueOf(order.getStatus().name()));
        orderRepository.save(orderEntity);
        return orderEntity.getId();
    }

    @Override
    public boolean existsOrder(String orderId, String userId) {
        log.info("Checking if order exists in DB with id {}", orderId);
        return orderRepository.existsById(orderId);
    }
}
