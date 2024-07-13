package personal.project.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.project.port.in.OrderUseCase;

@RestController
@RequestMapping("/order")
@Slf4j
@Component
public class OrderHttpController {

    @Autowired
    private OrderUseCase orderUseCase;

    @GetMapping("/{id}")
    public String getId(@PathVariable String id) {
        log.info("Receive request to list orders");
        boolean isExist = orderUseCase.existOrder(id);
        return isExist ? "Order found" : "Order not found";
    }
}
