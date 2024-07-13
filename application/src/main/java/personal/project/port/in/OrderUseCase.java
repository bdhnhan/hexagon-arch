package personal.project.port.in;

import personal.project.dto.OrderDto;

public interface OrderUseCase {
    boolean existOrder(String orderId, String userId);
    String createOrder(String userId);
}
