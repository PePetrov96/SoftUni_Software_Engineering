package Task_2_Shapes;

public class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculateArea();
        this.calculatePerimeter();
    }

    @Override
    public void calculateArea() {
        setArea(this.height * this.width);
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(this.height * 2 + this.width * 2);
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    protected Double getHeight() {
        return height;
    }

    protected Double getWidth() {
        return width;
    }
}