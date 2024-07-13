package personal.project.port.out;

import personal.project.domain.OrderDomain;

public interface OrderStoragePort {
    String storeOrder(OrderDomain orderDomain);
    boolean existsOrder(String orderId, String userId);
}
