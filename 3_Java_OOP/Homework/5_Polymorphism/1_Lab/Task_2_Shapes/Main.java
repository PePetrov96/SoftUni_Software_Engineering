package Task_2_Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(3D, 3D);
        Shape circle = new Circle(3D);

        System.out.println("rectangle-area: " + rectangle.getArea());
        System.out.println("rectangle-perimeter: " + rectangle.getPerimeter());
        System.out.println("circle-area: " + circle.getArea());
        System.out.println("circle-perimeter: " + circle.getPerimeter());

    }
}