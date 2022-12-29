public class Rectangle {
    private final Point bottomLeft;
    private final Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        return this.bottomLeft.getX() <= point.getX() &&
                this.bottomLeft.getY() <= point.getY() &&

                this.topRight.getX() >= point.getX() &&
                this.topRight.getY() >= point.getY();
    }
}