package DesignPhilosophy.LiskovSubstitutionPrinciple;

/**
 * @ClassName: Square
 * @Description: 正方形子类
 * @author: SevenBusData
 * @since: 2025/10/10
 */
public class Square extends Rectangle {

    public Square(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setLength(width);
        super.setWidth(width);
    }
}
