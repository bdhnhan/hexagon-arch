package personal.project.dto;

import lombok.Data;

@Data
public class OrderDto {
    private String id;
    private long amount;
    private long createdTime;
    private String userId;
    private OrderStatusEnum status;

    public enum OrderStatusEnum {
        INIT,
        PROCESSING,
        FAILED,
        SUCCESS,
        PENDING,
        FINAL_PENDING
    }
}
