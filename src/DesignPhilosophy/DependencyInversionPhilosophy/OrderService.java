package DesignPhilosophy.DependencyInversionPhilosophy;

/**
 * @ClassName: OrderService
 * @Description: 高层模块：订单处理服务（依赖抽象Storage，而非具体类）
 * @author: SevenBusData
 * @since: 2025/10/12
 */
public class OrderService {
    private Storage storage;

    /**
     * 构造函数注入：通过参数接收抽象的实现，由外部决定用哪种存储
     * @param storage
     */
    public OrderService(Storage storage) {
        this.storage = storage;
    }

    public void processOrder(String orderId) {
        // 业务逻辑与具体存储解耦，只需调用抽象方法
        storage.saveOrder(orderId);
    }
}
