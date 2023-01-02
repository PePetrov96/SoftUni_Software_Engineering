package Task_1_Class_Box_Data_Validation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double calculateSurfaceArea (){
        return (2 * this.getLength() * this.getWidth()) + (2 * this.getLength() * this.getHeight()) + (2 * this.getWidth() * this.getHeight());
    }

    public double calculateLateralSurfaceArea (){
        return (2 * this.getLength() * this.getHeight()) + (2 * this.getWidth() * this.getHeight());
    }

    public double calculateVolume (){
        return this.getLength() * this.getWidth() * this.getHeight();
    }

    private void setLength(double length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width < 1) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height < 1) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    private double getLength() {
        return length;
    }

    private double getWidth() {
        return width;
    }

    private double getHeight() {
        return height;
    }
}