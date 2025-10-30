package CreationalPattern.SingletonPattern.LazybonesStyle.demo1;

/**
 * @Description: 懒汉式单例模式
 *      在类被使用的时候才会被创建
 */
public class Singleton {
    // 私有构造器，外部无法直接创建一个对应
    private Singleton() {}

    // 创建一个私有静态类对象
    private static Singleton instance;

    // 公共可获取对象的静态方法, 不加 synchronized 同步锁关键字 可能会出现线程不安全的情况
    public static synchronized Singleton getInstance() {
        if(instance != null) {
            instance = new Singleton();
        }
        return instance;
    }
}
