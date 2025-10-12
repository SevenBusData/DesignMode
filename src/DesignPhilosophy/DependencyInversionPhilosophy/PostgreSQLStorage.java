package DesignPhilosophy.DependencyInversionPhilosophy;

/**
 * @ClassName: PostgreSQLStorage
 * @Description: 低层实现2：PostgreSQL存储（遵循Storage抽象）
 * @author: SevenBusData
 * @since: 2025/10/12
 */
public class PostgreSQLStorage implements Storage {
    @Override
    public void saveOrder(String orderId) {
        System.out.println("用PostgreSQL保存订单：" + orderId);
    }
}
