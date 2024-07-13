package personal.project.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import personal.project.port.out.OrderStoragePort;

import java.util.Set;

@Primary
@Service
public class OrderCacheAsideAdapter implements OrderStoragePort {

    private static final Set<String> orderIds = Set.of("123");

    @Autowired
    private OrderPersistenceAdapter orderPersistenceAdapter;

    @Override
    public String storeOrder(String id) {
        return "Cache not support this method";
    }

    @Override
    public boolean existsOrder(String orderId) {
        if (orderIds.contains(orderId)) {
            return true;
        }
        return orderPersistenceAdapter.existsOrder(orderId);
    }
}
