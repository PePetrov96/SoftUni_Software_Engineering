import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private final Deque<T> content;
    public Jar() {
        this.content = new ArrayDeque<>();
    }

    public void add(T element) {
        this.content.push(element);
    }

    public T remove() {
        return this.content.pop();
    }
}