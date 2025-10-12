# 依赖倒转原则

## 一、依赖倒转原则的核心定义
* 高层模块不应该依赖低层模块，二者都应该依赖于抽象
  * 高层模块：指系统中负责业务逻辑、流程控制的模块（如 “订单处理服务”“用户管理服务”），它们定义了系统的核心功能。 
  * 低层模块：指实现具体细节的模块（如 “MySQL 数据库操作”“Redis 缓存操作”“短信发送接口”），它们是高层模块的 “工具”。 
  * 抽象：通常指接口（Interface）或抽象类（Abstract Class），它定义了 “做什么”，但不包含 “怎么做” 的具体实现。
* 抽象不应该依赖于具体实现，具体实现应该依赖于抽象
  * 抽象是稳定的：业务逻辑的核心需求（如 “数据需要持久化”）通常不会频繁变化，因此抽象（如 “数据持久化接口”）是系统的 “稳定层”。 
  * 具体实现是易变的：实现细节（如从 “MySQL” 切换到 “PostgreSQL”，从 “短信” 切换到 “邮件”）可能因需求、技术迭代而变化，具体实现必须遵循抽象定义的规则，而非反过来让抽象适配实现。
## 二、为什么需要依赖倒转原则？（反例分析）
如果不遵循依赖倒转原则，会导致 “高层模块直接依赖低层模块”，形成紧耦合的代码结构，存在以下问题：  
* 难以扩展：新增低层实现时，需修改高层模块代码（如从 “MySQL” 切换到 “MongoDB”，需修改所有调用 MySQL 的业务逻辑）。 
* 难以测试：高层模块依赖具体的低层实现（如真实数据库），无法单独对高层模块进行单元测试（需启动数据库才能测试）。 
* 维护成本高：一处低层模块修改可能引发多个高层模块的连锁反应。

**反例代码（紧耦合）：**  
假设一个 “订单处理系统”，高层模块OrderService直接依赖低层模块MySQLStorage（具体数据库实现）：  
```Java
// 低层模块：MySQL数据库实现（具体类）
class MySQLStorage {
    public void saveOrder(String orderId) {
        System.out.println("用MySQL保存订单：" + orderId);
    }
}

// 高层模块：订单处理服务（依赖具体低层模块）
class OrderService {
    // 直接依赖具体类MySQLStorage，耦合度极高
    private MySQLStorage storage = new MySQLStorage();

    public void processOrder(String orderId) {
        // 业务逻辑：创建订单、验证信息...
        storage.saveOrder(orderId); // 直接调用MySQL的实现
    }
}
```
**问题:** 若后续需要将数据库切换为PostgreSQL，必须修改OrderService的代码（替换MySQLStorage为PostgreSQLStorage），违反了 “开闭原则”。
## 三、如何遵循依赖倒转原则？（正例实现）
遵循依赖倒转原则需三步：**定义抽象→低层实现抽象→高层依赖抽象**，同时结合 “依赖注入”（DI）避免高层模块主动创建低层实例。
### 正例代码（松耦合）
#### 1. 定义抽象（接口 / 抽象类）
抽象定义了高层模块需要的 “能力”，不涉及具体实现：
```java
// 抽象：数据持久化接口（定义“做什么”）
interface Storage {
    void saveOrder(String orderId); // 仅声明方法，无实现
}
```
#### 2. 低层模块实现抽象
所有具体的低层模块都需实现抽象接口，确保符合高层模块的 “能力要求”：
```java
// 低层实现1：MySQL存储（遵循Storage抽象）
class MySQLStorage implements Storage {
    @Override
    public void saveOrder(String orderId) {
        System.out.println("用MySQL保存订单：" + orderId);
    }
}

// 低层实现2：PostgreSQL存储（遵循Storage抽象）
class PostgreSQLStorage implements Storage {
    @Override
    public void saveOrder(String orderId) {
        System.out.println("用PostgreSQL保存订单：" + orderId);
    }
}
```
#### 3. 高层模块依赖抽象（结合依赖注入）
高层模块不再主动创建低层实例，而是通过 “构造函数注入”“ setter 注入” 等方式接收抽象的实现，彻底解除对具体类的依赖：
```java
// 高层模块：订单处理服务（依赖抽象Storage，而非具体类）
class OrderService {
    private Storage storage;

    // 构造函数注入：通过参数接收抽象的实现，由外部决定用哪种存储
    public OrderService(Storage storage) {
        this.storage = storage;
    }

    public void processOrder(String orderId) {
        // 业务逻辑与具体存储解耦，只需调用抽象方法
        storage.saveOrder(orderId);
    }
}
```
#### 4. 客户端组装（控制反转，IoC）
由客户端（或框架，如 Spring）决定使用哪个具体实现，并注入到高层模块中，高层模块无需关心 “用谁”：
```java
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
```
**优势：**  
* 扩展灵活：新增RedisStorage时，只需实现Storage接口，无需修改OrderService。 
* 测试便捷：单元测试时，可注入 “模拟实现”（如MockStorage），无需依赖真实数据库。 
* 耦合度低：高层与低层通过抽象隔离，低层变化不影响高层。
### 四、遵循依赖倒转原则的注意事项
1. 抽象要稳定，避免频繁修改  
   抽象是系统的 “契约”，若抽象频繁变更（如新增、删除方法），所有实现类和依赖它的高层模块都需修改，违背设计初衷。抽象应聚焦 “核心不变的需求”。
2. 避免过度抽象  
   若系统中某个功能只有一种实现（且未来几乎不会变化，如 “基于公司内网的身份验证”），无需强行定义抽象接口 —— 过度抽象会增加代码复杂度，无实际收益。
3. 依赖注入需简洁  
   优先使用 “构造函数注入”（明确依赖，确保对象创建时依赖已就绪），避免滥用 “setter 注入”（可能导致对象处于未就绪状态）。复杂系统可借助 Spring、Guice 等 IoC 框架管理依赖，减少手动注入的冗余代码。

### 五、总结
依赖倒转原则的本质是通过 “抽象” 隔离 “变与不变”：
* 不变的：高层模块的业务逻辑、核心需求（通过抽象定义）。
* 可变的：低层模块的具体实现（通过抽象的多态实现灵活替换）。  
  遵循该原则可让系统从 “紧耦合的硬编码” 转变为 “松耦合的弹性架构”，是应对需求变化、提升代码质量的关键设计思想，尤其在大型系统、框架开发中不可或缺。


