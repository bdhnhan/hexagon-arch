package personal.project.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class OrderEntity {

    @Id
    private String id;
    private long amount;
    private Timestamp createdTime;
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
