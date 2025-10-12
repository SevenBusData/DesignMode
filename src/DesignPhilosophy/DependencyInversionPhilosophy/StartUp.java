package DesignPhilosophy.DependencyInversionPhilosophy;

/**
 * @ClassName: StartUp
 * @Description: 启动类
 * @author: SevenBusData
 * @since: 2025/10/12
 */
public class StartUp {
    public static void main(String[] args) {
        // 1. 选择具体实现（如切换为PostgreSQL，只需修改这一行）
        Storage storage = new PostgreSQLStorage();
        // Storage storage = new MySQLStorage();

        // 2. 注入到高层模块
        OrderService orderService = new OrderService(storage);

        // 3. 执行业务逻辑
        orderService.processOrder("ORDER_001");
    }
}
