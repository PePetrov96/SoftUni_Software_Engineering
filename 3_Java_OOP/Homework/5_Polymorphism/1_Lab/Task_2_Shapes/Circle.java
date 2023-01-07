package Task_2_Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    @Override
    public void calculateArea() {
        setArea((this.radius * this.radius) * Math.PI);
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(2 * Math.PI * this.radius);
    }

    protected final Double getRadius() {
        return radius;
    }

    private void setRadius(Double radius) {
        this.radius = radius;
    }
}
