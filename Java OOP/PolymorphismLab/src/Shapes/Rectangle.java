package Shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
        this.calculateArea();
        this.calculatePerimeter();
    }

    public final double getHeight() {
        return height;
    }

    public final double getWidth() {
        return width;
    }

    @Override
    protected void calculatePerimeter() {
        this.setPerimeter(this.height * 2 + this.width * 2);
    }

    @Override
    protected void calculateArea() {
        this.setArea(this.height * this.width);
    }
}
