import java.util.*;
import java.util.function.Consumer;

public class CustomStack implements Iterable<Integer> {
    private final Deque<Integer> stack;

    public CustomStack() {
        this.stack = new ArrayDeque<>();
    }

    public void Push(int value) {
        this.stack.push(value);
    }

    public void Pop() {
        if (iterator().hasNext()) {
            System.out.println("No elements");
        } else {
            this.stack.pop();
        }
    }

    public void forEachModified(Consumer<? super Integer> consumer) {
        for (int value : this.stack) {
            consumer.accept(value);
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }
    private class CustomIterator implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return stack.isEmpty();
        }

        @Override
        public Integer next() {
            return stack.peek();
        }
    }
}