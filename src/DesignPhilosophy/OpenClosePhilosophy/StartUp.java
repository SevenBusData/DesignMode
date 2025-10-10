package DesignPhilosophy.OpenClosePhilosophy;

/**
 * @Description: 开闭原则启动类
 */
public class StartUp {
    public static void main(String[] args) {
        AbstractSkin defaultSkin = new DefaultSkin();
        AbstractSkin famousSkin = new FamousSkin();
        defaultSkin.display();
        famousSkin.display();
    }
}
