package CreationalPattern.SingletonPattern.EagerStyle.demo1;

/**
 * @Description: 饿汉式单例模式
 *      在类被加载的时候创建一个对象
 */
public class Singleton {
    // 私有构造器，外部无法直接创建一个对应
    private Singleton() {}

    // 创建一个私有静态类对象
    private static Singleton instance = new Singleton();

    // 公共可获取对象的静态方法
    public static Singleton getInstance() {
        return instance;
    }
}
