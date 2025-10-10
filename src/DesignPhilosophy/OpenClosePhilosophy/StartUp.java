package DesignPhilosophy.OpenClosePhilosophy;

public class StartUp {
    public static void main(String[] args) {
        AbstractSkin defaultSkin = new DefaultSkin();
        AbstractSkin famousSkin = new FamousSkin();
        defaultSkin.display();
        famousSkin.display();
    }
}
