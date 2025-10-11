package DesignPhilosophy.LiskovSubstitutionPrinciple;

/**
 * @ClassName: Rectangle
 * @Description: 长方形父类
 * @author: SevenBusData
 * @since: 2025/10/10
 */
public class Rectangle {
    private double length;
    private double width;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
