package personal.project.port.out;

public interface OrderStoragePort {
    String storeOrder(String id);
    boolean existsOrder(String orderId);
}
