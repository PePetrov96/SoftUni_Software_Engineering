public class Box<T> {
    private final T element;

    public Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.format(this.element.getClass().getName() + ": " + this.element);
    }
}