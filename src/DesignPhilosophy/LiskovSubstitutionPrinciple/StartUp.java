package DesignPhilosophy.LiskovSubstitutionPrinciple;

/**
 * @ClassName: StartUp
 * @Description: 里氏替换原则启动类
 * @author: SevenBusData
 * @since: 2025/10/10
 */
public class StartUp {
    public static void main(String[] args) {
        RectangleOperation rectangleOperation = new RectangleOperation();
        Rectangle square = new Square(5);
        Rectangle rectangle = new Rectangle(8, 6);
        System.out.println("正方形");
        rectangleOperation.Perimeter(square);
        rectangleOperation.Area(square);
        rectangleOperation.OutputTheSideLength(square);
        System.out.println("长方形");
        rectangleOperation.Perimeter(rectangle);
        rectangleOperation.Area(rectangle);
        rectangleOperation.OutputTheSideLength(rectangle);
    }
}
