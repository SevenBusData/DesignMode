package DesignPhilosophy.LiskovSubstitutionPrinciple;

/**
 * @ClassName: RectangleOperation
 * @Description: 长方形的属性类
 * @author: SevenBusData
 * @since: 2025/10/10
 */
public class RectangleOperation {
    /**
     * 计算周长
     * @param rectangle
     */
    public void Perimeter(Rectangle rectangle) {
        double perimeter = (rectangle.getLength() + rectangle.getWidth()) * 2;
        System.out.println("Perimeter: " + perimeter);
    }

    public void Area(Rectangle rectangle) {
        double area = rectangle.getLength() * rectangle.getWidth();
        System.out.println("Area: " + area);
    }

    public void OutputTheSideLength(Rectangle rectangle) {
        System.out.println("Length: " + rectangle.getLength() + ", Width: " + rectangle.getWidth());
    }
}
