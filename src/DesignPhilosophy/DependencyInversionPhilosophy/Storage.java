package DesignPhilosophy.DependencyInversionPhilosophy;

/**
 * @ClassName: Storage
 * @Description: 抽象：数据持久化接口（定义“做什么”）
 * @author: SevenBusData
 * @since: 2025/10/12
 */
public interface Storage {
    void saveOrder(String orderId);
}
