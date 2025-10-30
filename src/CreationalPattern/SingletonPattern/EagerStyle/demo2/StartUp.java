package CreationalPattern.SingletonPattern.EagerStyle.demo2;

/**
 * @Description: 实现类
 */
public class StartUp {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println("判断两个对象是否是同一个对象" + (singleton1 == singleton2));
    }
}
