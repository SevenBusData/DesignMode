package DesignPhilosophy.InterfaceSegregationPrinciple;

/**
 * @ClassName: OrderService
 * @Description: TODO
 * @author: SevenBusData
 * @since: 2025/10/12
 */
public interface OrderService {
    Order createOrder(String productId, String userId);
}
