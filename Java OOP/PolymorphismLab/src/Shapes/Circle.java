package Shapes;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        this.calculateArea();
        this.calculatePerimeter();
    }

    public final double getRadius() {
        return radius;
    }

    @Override
    public void calculatePerimeter() {
        if (this.getPerimeter() == 0) {
            this.setPerimeter(this.radius * 2 * Math.PI);
        }
    }

    @Override
    public void calculateArea() {
        if(this.getArea()==0){
            this.setArea(this.radius * this.radius * Math.PI);
        }
    }
}
