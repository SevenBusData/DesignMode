package DesignPhilosophy.DependencyInversionPhilosophy;

/**
 * @ClassName: MySQLStorage
 * @Description: 低层实现1：MySQL存储（遵循Storage抽象）
 * @author: SevenBusData
 * @since: 2025/10/12
 */
public class MySQLStorage implements Storage {
    @Override
    public void saveOrder(String orderId) {
        System.out.println("用MySQL保存订单：" + orderId);
    }
}
