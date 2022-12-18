public class Scale <T extends Comparable<T>> {
    private final T left;
    private final T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (this.left.compareTo(this.right) == 0) {
            return null;
        } else if (this.left.compareTo(this.right) < 0) {
            return this.right;
        } else {
            return this.left;
        }
    }
}