package CreationalPattern.SingletonPattern.LazybonesStyle.demo2;

/**
 * @Description: 懒汉式单例模式
 *      在类被使用的时候才会被创建么，双重检查锁的方式
 */
public class Singleton {
    // 私有构造器，外部无法直接创建一个对应
    private Singleton() {}

    // 创建一个私有静态类对象
    private static Singleton instance;

    // 公共可获取对象的静态方法, 不加 synchronized 同步锁关键字 可能会出现线程不安全的情况
    public static Singleton getInstance() {
        if(instance == null) {
            // 只有在写操作的时候，才需要加上synchronized关键字，提升性能
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
