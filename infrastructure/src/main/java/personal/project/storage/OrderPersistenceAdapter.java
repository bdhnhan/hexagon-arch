package personal.project.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import personal.project.port.out.OrderStoragePort;

import java.util.Set;

@Component
@Slf4j
public class OrderPersistenceAdapter implements OrderStoragePort {

    private static final Set<String> orderIds = Set.of("123", "456", "789");

    @Override
    public String storeOrder(String orderId) {
        return orderId + "_created";
    }

    @Override
    public boolean existsOrder(String orderId) {
        log.info("Checking if order exists in DB with id {}", orderId);
        return orderIds.contains(orderId);
    }
}
