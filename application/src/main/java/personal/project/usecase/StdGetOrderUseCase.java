package personal.project.usecase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.project.port.in.OrderUseCase;
import personal.project.port.out.OrderStoragePort;

@Slf4j
@Service
public class StdGetOrderUseCase implements OrderUseCase {

    @Autowired
    private OrderStoragePort orderStoragePort;


    @Override
    public boolean existOrder(String orderId) {
        //Validate
        //biz logic
        boolean isExist = orderStoragePort.existsOrder(orderId);
        if (isExist) {
            log.info("Order with id {} exists", orderId);
        } else {
            log.info("Order with id {} not exists", orderId);
        }
        return isExist;
    }
}
